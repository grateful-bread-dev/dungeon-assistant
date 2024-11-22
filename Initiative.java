import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This enters the characters' names
 * and sets initiative for combat.
 *
 * Initiative - Dungeon Assistant
 * @author Jonathan Braun
 * @version 11-20-2024
 */
public class Initiative {
   
   private List<Player> players;
   
   // Constructor
   public Initiative() {
      this.players = new ArrayList<>();
   }
   
   // Add player initiative
   public void addPlayer(String name, int initiativeRoll) {
      players.add(new Player(name, initiativeRoll));
      System.out.println(name + " with initiative " + initiativeRoll
         + " has been added.");
   }
   
   // Remove a player from initiative list
   public boolean removePlayer(String name) {
      for (Player player : players) {
         if (player.getName().equalsIgnoreCase(name)) {
            players.remove(player);
            System.out.println(name + " has been removed from the initiative, M'Lord.");
            return true;
         }
      }
      System.out.println(name + " was not found in the initiative, M'Lord.");
      return false;
   }
   
   // Updated: Display initiative order as a String
   public String displayInitiativeOrder() {
      if (players.isEmpty()) {
         return "Sire, there are no players in the initiative order.";
      }
      
      StringBuilder order = new StringBuilder("Initiative Order:\n");
      for (Player player : players) {
         order.append("\t- ").append(player.getName())
              .append(" (Initiative: ").append(player.getInitiative())
              .append(")\n");
      }
      return order.toString();
   }
   
   // Sort players' initiative in descending order
   public void sortPlayersByInitiative() {
      // CompareTo method in Player
      Collections.sort(players);
      System.out.println("Players have been sorted by initiative. "
         + "\nHappy Killing, your excellency!");
   }
   
   // Clear initiative
   public void clearPlayers() {
      players.clear();
      System.out.println("The initiative has been cleared. May their blood flow "
         + "like a river yet again.");
   }
}
