package application;



import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameBoard {
	BorderPane board;
	Player currentPlayer;
	public GameBoard(BorderPane board) {
		this.board = board;
		displayStartScreen();
	}
	
	// Show a start screen
	private void displayStartScreen() {
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				displayPlayerSelect();
			}
			
		};
		Label title = new Label("Clue");
		title.getStyleClass().add("title");
		HBox titleBar = new HBox(title);
		titleBar.setAlignment(Pos.CENTER);
		Button start = new Button("Start");
		start.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		board.setTop(titleBar);
		board.setCenter(start);
	}
	
	private void displayPlayerSelect() {
		Label playersLabel = new Label("Number of Players:");
		playersLabel.getStyleClass().add("title");
		board.setTop(playersLabel);
		String playerOptions[] = {"1", "2", "3", "4"};
		ComboBox<String> cmb = new ComboBox(FXCollections.observableArrayList(playerOptions));
		board.setCenter(cmb);
		
	}
	
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
	
	
	
}
