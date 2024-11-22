import java.util.Random;

/**
 * Handles combat dice rolls.
 *
 * Combat - Dungeon Assistant
 * @author Jonathan Braun
 * @version 11-21-2024
 */
public class Combat {

   private Random random;

   // Constructor
   public Combat() {
      random = new Random();
   }

   /**
    * Rolls a specified number of dice with a specified number of sides,
    * adds the modifier, and calculates the total.
    *
    * @param sides The number of sides on the dice (e.g., 4, 6, 8, 10, 12, 20).
    * @param numberOfDice The number of dice to roll.
    * @param modifier The value to add (or subtract) from the roll.
    * @return The total result of the dice rolls with the modifier applied.
    */
   public int rollDice(int sides, int numberOfDice, int modifier) {
      System.out.println("Combat.rollDice called with sides: " + sides
         + ", numberOfDice: " + numberOfDice + ", modifier: " + modifier);
   
      int total = 0;
   
   // Roll each die
      for (int i = 0; i < numberOfDice; i++) {
         int roll = random.nextInt(sides) + 1; // Random roll between 1 and `sides`
         System.out.println("Rolled: " + roll); // Debugging: log each roll
         total += roll;
      }
   
   // Log total before modifier
      System.out.println("Total before modifier: " + total);
   
   // Apply modifier
      total += modifier;
   
   // Log final total
      System.out.println("Total after applying modifier: " + total);
   
      return total;
   }

}
