/**
 * This class creates players which will be
 * used in the function of other classes.
 *
 * Player - Dungeon Assistant
 * @author Jonathan Braun
 * @version 11-20-2024
 */
public class Player implements Comparable<Player> {

   private String name;
   private int initiative;
   
//constructor
   public Player(String name, int initiative) {
      this.name = name;
      this.initiative = initiative;
   }
   
//get the player name
   public String getName() {
      return name;
   }
   
//setter for player name
   public void setName(String name) {
      this.name = name;
   }
   
//get the initiative
   public int getInitiative() {
      return initiative;
   }
   
//set the player initiative
   public void setInitiative() {
      this.initiative = initiative;
   }   
   
//compare for sorting
   @Override
   public int compareTo(Player player) {
      return Integer.compare(player.initiative, this.initiative);
   }
   
//toString method
   @Override
   public String toString() {
      return "Player (name = " + name + ", initiative = " 
         + initiative + ")";
   }                                       
    
}