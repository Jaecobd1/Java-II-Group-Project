// Project Name: Clue
// Started by: Daniel Reyes
// Description: Assumptions page, when user reaches a room creates pop up with drop down menu
// for categories.

package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.Random;

public class Assumptions {
    
    // Arrays used for random Assumption
    private String ranSuspects[] = {
            "Mrs. White",
            "Mrs. Peacock",
            "Professor Plum",
            "Colonel Mustard",
            "Miss Scarlett",
            "Reverend Green",
    };
    private String ranWeapons[] = {
            "Knife",
            "Revolver",
            "Rope",
            "Wrench",
            "Candelstick",
            "Lead Pipe",
    };
    private String ranRooms[] = {
            "BallRoom",
            "Billards Room",
            "Conservatory",
            "Dining Room",
            "Hall",
            "Kitchen",
            "Lounge",
            "Libaray",
            "Study",
    };
    
    // Pop up window.
    private Stage stage;
    
    // OK Button
    private Button okButton;
    
    // The drop down menus.
    private ComboBox<String> dropSuspect;
    private ComboBox<String> dropWeapon;
    private ComboBox<String> dropRoom;
    
    // Initializes the pop up and sets up its components.
    public Assumptions() 
    {
    // Initialize stage and layout
        stage = new Stage();
        GridPane gridPane = new GridPane();

    // Initialize components
        dropSuspect = new ComboBox<>();
        dropWeapon = new ComboBox<>();
        dropRoom = new ComboBox<>();
        okButton = new Button("Ok");
        
    // Use method to configure components
        configComponents();
        getData();
        
    // Set up layout
        gridPane.add(new Label("Suspect:"), 0, 0);
        gridPane.add(dropSuspect, 1, 0);
        gridPane.add(new Label("Weapon:"), 0, 1);
        gridPane.add(dropWeapon, 1, 1);
        gridPane.add(new Label("Room:"), 0, 2);
        gridPane.add(dropRoom, 1, 2);

    // Place button
        gridPane.add(okButton, 0, 3, 2, 1);
        
    // Set scene
        Scene scene = new Scene(gridPane, 300, 200);
        
    // Handle Button Event
        okButton.setOnAction(e -> {
            close();
            });
        
        stage.setScene(scene);
    }
    
    // Configures the drop downs, button, etc.
    private void configComponents()
    {
    // Configure drop downs
        dropSuspect.getItems().addAll("Mrs. White", "Mrs. Peacock", "Professor Plum", "Colonel Mustard", "Miss Scarlett", "Reverend Green");
        dropWeapon.getItems().addAll("Knife", "Revolver", "Rope", "Wrench", "Candelstick", "Lead Pipe");
        dropRoom.getItems().addAll("BallRoom", "Billards Room", "Conservatory", "Dining Room", "Hall", "Kitchen", "Lounge", "Libaray","Study");
        
    // Event handlers
        dropSuspect.setOnAction(e -> {
            String SelVal1 = dropSuspect.getValue();
            });
        
        dropWeapon.setOnAction(e -> {
            String SelVal2 = dropWeapon.getValue();
            });
        
        dropRoom.setOnAction(e -> {
            String SelVal3 = dropRoom.getValue();
            });
 
    }
    
    // Used to display the pop up on the GameBoard.
    public void show() 
    {
    // Show pop up
        stage.show();
    }
    
    // Retrieve selected values from drop downs
    // Should return to use the data as needed
    public String[] getData() 
    {
     // Retrieve selected values
        String value1 = dropSuspect.getValue();
        String value2 = dropWeapon.getValue();
        String value3 = dropRoom.getValue();
        
     // return values
        return new String[] {value1, value2, value3};
                
    }
    
    // Creates a random assumption for NPC
    public String[] ranAssumption() 
    {
        // Generates value for each category
        Random random = new Random();
        
        String value1 = ranSuspects[random.nextInt(5-0+1) + 0];
        String value2 = ranWeapons[random.nextInt(5-0+1)+0];
        String value3 = ranRooms[random.nextInt(8-0+1)+0];
        
        // return values
        return new String[] {value1, value2, value3};
        
    }
    
    // Closes the pop-up
    public void close() {
        // Close the pop-up
        stage.close();
    }


}

/*
 // Retrieve selected values from drop downs
    // Should return to use the data as needed
    public void getDataSuspect() 
    {
    // get values
        String Value1 = dropSuspect.getValue();
     // get values
        //return Value1;
        
    }
    
    public String getDataWeapon() 
    {
     // get value
        String Value2 = dropWeapon.getValue();
     // return value
        return Value2;
    }
    
    public String getDataRoom() 
    {
     // get value
        String Value3 = dropRoom.getValue();
     // return value
        return Value3;
    }
    
 */
