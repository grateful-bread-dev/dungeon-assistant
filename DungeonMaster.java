import javax.swing.*;
/**
 *
 * This class handles all relevant data
 * from other classes and prints info.
 *
 * DungeonMaster - Dungeon Assistant
 * @author Jonathan Braun
 * @version 11-20-2024
 */  
public class DungeonMaster {
   private String currentMenu = "main"; // Tracks the current menu
   private Initiative initiative; // Handles initiative logic
   private Boss boss; // Handles boss management logic
   private Combat combat; // Handles combat logic


   
   public DungeonMaster() {
      initiative = new Initiative();
      combat = new Combat();
   }

   
       // Returns the welcome message
   public String getWelcomeMessage() {
      return """
                  -------------------------------------------
                  Welcome, M'Lord, to the Dungeon Master Menu
                  -------------------------------------------""";
   }
   
       // Returns the main menu options
   public String getMainMenu() {
      return """
                  1. Initiative
                  2. Combat
                  3. Boss Management
                  4. Exit
                  
                  Enter your choice:""";
   }
   
       // Processes user input and returns the resulting output
   public String processInput(String input) {
      System.out.println("Current menu: " + currentMenu + ", User input: " + input); // Debugging
   
      switch (currentMenu) {
         case "main" -> {
            System.out.println("Routing to handleMainMenu"); // Debugging
            return handleMainMenu(input);
         }
         case "initiative" -> {
            System.out.println("Routing to handleInitiativeMenu"); // Debugging
            return handleInitiativeMenu(input);
         }
         case "combat" -> {
            System.out.println("Routing to handleCombatMenu"); // Debugging
            return handleCombatMenu(input);
         }
         case "boss" -> {
            System.out.println("Routing to handleBossMenu"); // Debugging
            return handleBossMenu(input);
         }
         default -> {
            System.out.println("Unexpected error encountered"); // Debugging
            currentMenu = "main";
            return "Unexpected error. Returning to Main Menu.\n" + getMainMenu();
         }
      }
   }

   
       // Handle input for the main menu
   private String handleMainMenu(String input) {
      switch (input) {
         case "1" -> {
            currentMenu = "initiative";
            return getInitiativeMenu();
         }
         case "2" -> {
            currentMenu = "combat";
            return getCombatMenu();
         }
      
         case "3" -> {
            currentMenu = "boss";
            return getBossMenu();
         }
         case "4" -> {
            System.out.println("Exiting program. Farewell!"); // Optional debug log
            JOptionPane.showMessageDialog(null, "Like Lord Strahd returning to his slumber, I leave you.\nGoodbye!", 
               "Farewell", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); // Terminate the program
            return ""; // This line is technically unreachable but required for syntax
         }
      
         default -> {
            return "Oops! You rolled a Nat 1. Please reroll.\n" + getMainMenu();
         }
      }
   }
   
       // Initiative menu options
   private String getInitiativeMenu() {
      return """
                  --- Initiative Menu ---
                  1. Add Player to Initiative
                  2. Remove Player from Initiative
                  3. Display Initiative Order
                  4. Sort Initiative Order
                  5. Clear Initiative
                  6. Back to Main Menu
                  
                  Choose an option:""";
   }
   
   private String handleInitiativeMenu(String input) {
      switch (input) {
         case "1" -> {
            String name = JOptionPane.showInputDialog("Enter player name:");
            String rollStr = JOptionPane.showInputDialog("Enter initiative roll:");
            try {
               int roll = Integer.parseInt(rollStr);
               initiative.addPlayer(name, roll);
               return "Player " + name + " added with roll " + roll + ".\n" + getInitiativeMenu();
            } catch (NumberFormatException ex) {
               return "Invalid roll number. Please try again.\n" + getInitiativeMenu();
            }
         }
         case "2" -> {
            String name = JOptionPane.showInputDialog("Enter player name to remove:");
            initiative.removePlayer(name);
            return "Player " + name + " removed from initiative.\n" + getInitiativeMenu();
         }
         case "3" -> {
            String order = initiative.displayInitiativeOrder(); // Now works correctly
            return order + "\n" + getInitiativeMenu();
         }
         case "4" -> {
            initiative.sortPlayersByInitiative();
            return "Initiative order sorted.\n" + getInitiativeMenu();
         }
         case "5" -> {
            initiative.clearPlayers();
            return "Initiative list cleared.\n" + getInitiativeMenu();
         }
         case "6" -> {
            currentMenu = "main";
            return getMainMenu();
         }
         default -> {
            return "Oops! You rolled a Nat 1. Please reroll.\n" + getInitiativeMenu();
         }
      }
   }
   
   // Combat menu options
   private String getCombatMenu() {
      return """
           --- Combat Menu ---
           1. Roll d4
           2. Roll d6
           3. Roll d8
           4. Roll d10
           5. Roll d12
           6. Roll d20
           7. Back to Main Menu
           
           Choose an option:""";
   }



   
       // Boss menu options
   private String getBossMenu() {
      return """
                  --- Boss Management Menu ---
                  1. Add a Boss
                  2. View Boss Information
                  3. Update Health Points
                  4. Update Notes
                  5. Back to Main Menu
                  
                  Choose an option:""";
   }
   
   private String handleBossMenu(String input) {
      switch (input) {
         case "1" -> {
            String name = JOptionPane.showInputDialog("Enter boss name:");
            String healthStr = JOptionPane.showInputDialog("Enter boss health points:");
            String notes = JOptionPane.showInputDialog("Enter notes (or leave blank):");
            try {
               int healthPoints = Integer.parseInt(healthStr);
               boss = new Boss(name, healthPoints, notes);
               return "Boss " + name + " added successfully.\n" + getBossMenu();
            } catch (NumberFormatException ex) {
               return "Invalid health points. Please try again.\n" + getBossMenu();
            }
         }
         case "2" -> {
            if (boss != null) {
               return boss.toString() + "\n" + getBossMenu();
            } else {
               return "No boss data available. Please add a boss first, M'Lord.\n" + getBossMenu();
            }
         }
         case "3" -> {
            if (boss != null) {
               String adjustmentStr = JOptionPane.showInputDialog("Enter health adjustment (+/-):");
               try {
                  int adjustment = Integer.parseInt(adjustmentStr);
                  boss.setHealthPoints(boss.getHealthPoints() + adjustment);
                  return "Boss health updated successfully.\n" + getBossMenu();
               } catch (NumberFormatException ex) {
                  return "Invalid adjustment. Please try again.\n" + getBossMenu();
               }
            } else {
               return "No boss data available. Please add a boss first.\n" + getBossMenu();
            }
         }
         case "4" -> {
            if (boss != null) {
               String notes = JOptionPane.showInputDialog("Enter new notes:");
               boss.setNotes(notes);
               return "Notes updated successfully.\n" + getBossMenu();
            } else {
               return "No boss data available. Please add a boss first.\n" + getBossMenu();
            }
         }
         case "5" -> {
            currentMenu = "main";
            return getMainMenu();
         }
         default -> {
            return "Invalid option. Please try again.\n" + getBossMenu();
         }
      }
   }
   
   private String handleCombatMenu(String input) {
      switch (input) {
         case "1" -> {
            return handleRoll(4);
         }
         case "2" -> {
            return handleRoll(6);
         }
         case "3" -> {
            return handleRoll(8);
         }
         case "4" -> {
            return handleRoll(10);
         }
         case "5" -> {
            return handleRoll(12);
         }
         case "6" -> {
            return handleRoll(20);
         }
         case "7" -> {
            currentMenu = "main";
            return getMainMenu();
         }
         default -> {
            return "Oops! You rolled a Nat 1. Please reroll.\n" + getCombatMenu();
         }
      }
   }
   
   private String handleRoll(int sides) {
      String numberOfDiceStr = JOptionPane.showInputDialog("How many d" + sides + "s?");
      int numberOfDice;
      try {
         numberOfDice = Integer.parseInt(numberOfDiceStr);
      } catch (NumberFormatException e) {
         return "Invalid number of dice. Please try again.\n" + getCombatMenu();
      }
   
      String modifierStr = JOptionPane.showInputDialog("Any pluses or minuses?");
      int modifier;
      try {
         modifier = Integer.parseInt(modifierStr);
      } catch (NumberFormatException e) {
         return "Invalid modifier. Please try again.\n" + getCombatMenu();
      }
   
      int total = combat.rollDice(sides, numberOfDice, modifier);
      return "You rolled " + numberOfDice + "d" + sides + " with a modifier of " + modifier
         + "\nTotal: " + total + "\n" + getCombatMenu();
   }

 


}
