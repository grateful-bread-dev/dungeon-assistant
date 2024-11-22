import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI class to display program for user.
 *
 * DungeonAssistantGUI - DungeonAssistant
 * @author Jonathan Braun
 * @version 11-20-2024
 */
public class DungeonAssistantGUI {
   private static JTextArea console;       // Text area for displaying output
   private static JTextField inputField;  // Text field for user input
   private static DungeonMaster dungeonMaster; // Core logic handler

   public static void main(String[] args) {
      // Create the DungeonMaster object
      dungeonMaster = new DungeonMaster();
   
      // GUI Setup
      JFrame frame = new JFrame("Dungeon Assistant");
      frame.setSize(800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      // Console for output
      console = new JTextArea();
      console.setEditable(false);
      console.setFont(new Font("Monospaced", Font.PLAIN, 14));
      JScrollPane scrollPane = new JScrollPane(console);
   
      // Input field for commands
      inputField = new JTextField();
      inputField.setFont(new Font("Monospaced", Font.PLAIN, 14));
      inputField.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String userInput = inputField.getText();
               inputField.setText(""); // Clear the input field
               handleUserInput(userInput.trim()); // Handle user input
            }
         });
   
      // Add components to the frame
      frame.setLayout(new BorderLayout());
      frame.add(scrollPane, BorderLayout.CENTER);
      frame.add(inputField, BorderLayout.SOUTH);
   
      // Display the frame
      frame.setVisible(true);
   
      // Start the program
      printToConsole(dungeonMaster.getWelcomeMessage()); // Welcome message
      printToConsole(dungeonMaster.getMainMenu()); // Display the main menu
   }

   // Print messages to the GUI console
   private static void printToConsole(String message) {
      console.append(message + "\n");
      console.setCaretPosition(console.getDocument().getLength());
   }

   // Handle user input and update the GUI
   private static void handleUserInput(String input) {
      if (input.isEmpty()) {
         printToConsole("Please enter a valid option.");
         return;
      }
      String response = dungeonMaster.processInput(input); // Delegate input to DungeonMaster
      printToConsole(response); // Update GUI with the response
   }
}
