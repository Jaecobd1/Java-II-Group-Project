package application;



import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Started by Jake Dobler

public class GameBoard {
	BorderPane board;
	Player currentPlayer;
	public GameBoard(BorderPane board) {
		this.board = board;
		displayStartScreen();
	}
	
	// Show a start screen
	// Allow user to move to player select
	private void displayStartScreen() {
		
		Label title = new Label("Clue");
		title.getStyleClass().add("title");
		HBox titleBar = new HBox(title);
		titleBar.setAlignment(Pos.CENTER);
		Button start = new Button("Start");
		start.setOnAction(e -> {
			
		displayGameBoard();
		});
		board.setTop(titleBar);
		board.setCenter(start);
	}
	
	private void displayGameBoard() {
		
	}
	
//	private void displayPlayerSelect() {
//		Label playersLabel = new Label("Number of Players:");
//		playersLabel.getStyleClass().add("title");
//		board.setTop(playersLabel);
//		String playerOptions[] = {"1", "2", "3", "4"};
//		ComboBox<String> cmb = new ComboBox(FXCollections.observableArrayList(playerOptions));
//		board.setCenter(cmb);
//		Button play = new Button("Play!");
//		
//		board.setBottom(play);
//		
//		play.setOnAction(e->{
//			int numOfPlayers = Integer.parseInt(cmb.getValue());
//			createPlayers(numOfPlayers);
//		});
//		
//	}
	
	// Add Rooms to GUI (Should Rooms just be oversized tiles) I.E. Rooms extend tile?
	
	// Create tiles representing moveable positions. Maybe everywhere there is not a room?
	// (there aren't moveable spots in the rooms of the real game)
	
	
	// For each clue group - 1 Add random clues to tiles
	// For randomness I would shuffle the list before the for loops
	
	// Functions for managing players and gameplay 
	private void nextPlayer() {
		currentPlayer = currentPlayer.next;
	}
	
	// Show currentPlayer 
	private void displayCurrentPlayer() {
		board.getChildren().clear();
		board.getChildren().add(new Label(currentPlayer.name));
		
	}
	
	
	// Stinky Code
//	private void createPlayers(int num) {
//		board.getChildren().clear();
//		VBox inputs = new VBox();
//		for(int i = 0; i < num ; i++) {
//			// Show an input for each players
//			int curPlayerNum = i +1;
//			Label nameLabel = new Label("Player #" + curPlayerNum + " name:");
//			TextField name = new TextField();
//			HBox nameHB = new HBox(nameLabel, name);
//			
//			inputs.getChildren().add(nameHB);
//		}
//		Button submit = new Button("Submit");
//		inputs.getChildren().add(submit);
//		board.setCenter(inputs);
//		submit.setOnAction(e->{
//			Player p1 = Player()
//		});
//	}
	
	
	
	
}
