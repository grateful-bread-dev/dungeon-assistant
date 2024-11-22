/**
 * 
 * Boss class contains relevant information
 * and stats for enemy bosses that players
 * will encounter and fight.
 *
 * Boss - Dungeon Assistant
 * @author Jonathan Braun
 * @version 11-20-2024
 */
public class Boss {
   private String name;
   private int healthPoints;
   private String notes;
   
//constructor
   public Boss(String name, int healthPoints, String notes) {
      this.name = name;
      this.healthPoints = healthPoints;
      this.notes = notes;
   }
   
//getter and setter
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public int getHealthPoints() {
      return healthPoints;
   }
   
   public void setHealthPoints(int healthPoints) {
      this.healthPoints = healthPoints;
   }
   
   public String getNotes() {
      return notes;
   }
   
   public void setNotes(String notes) {
      this.notes = notes;
   }
   
   // Override toString() for readable output
   @Override
   public String toString() {
      return """
               --- Boss Information ---
               Name: %s
               Health Points: %d
               Notes: %s
               """.formatted(name, healthPoints, 
                  notes == null || notes.isEmpty() ? "None" : notes);
   }               
}