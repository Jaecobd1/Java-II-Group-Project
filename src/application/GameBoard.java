package application;



import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		VBox titleBar = new VBox(title, new Label("Created by: Jake Dobler & Genevieve Mathews"));
		titleBar.setAlignment(Pos.CENTER);
		Button start = new Button("Start");
		start.setOnAction(e -> {
			
		startGame();
		});
		board.setTop(titleBar);
		board.setCenter(start);
	}
	
	private void startGame() {
		String suspects[] = {
				"Mrs. White",
				"Mrs. Peacock",
				"Professor Plum",
				"Colonel Mustard",
				"Miss Scarlett",
				"Reverend Green",
		};
		
		String weapons[] = {
				"Knife",
				"Revolver",
				"Rope",
				"Wrench",
				"Candelstick",
				"Lead Pipe",
		};
		String rooms[] = {
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
		
		// Create instances of all of the possible 
		// suspects, rooms and weapons
		Suspect suspectCards[] = new Suspect[6];
		int suspectCount = 0;
		for(String suspect: suspects) {
			suspectCards[suspectCount] = new Suspect(suspect);
			suspectCount++;
		}
		Weapon weaponCards[] = new Weapon[6];
		int weaponCount = 0;
		for (String weapon: weapons) {
			weaponCards[weaponCount] =  new Weapon(weapon);
			weaponCount++;
		}
		Room roomCards[] = new Room[9];
		int roomCount = 0;
		for (String room: rooms) {
			roomCards[roomCount] = new Room(room);
			roomCount++;
		}
		
		// Select a suspect, weapon, and room **Important part of game**
		
		for(Suspect suspect: suspectCards) {
			// Testing that it work
			System.out.println(suspect.clueName);
		}
		
		
		setUpGameBoard();
		
		
		
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
		board.getChildren().add(new Label(currentPlayer.name));
		
	}
	
	private void updateGameBoard() {
		
	}
	
	private void setUpGameBoard() {
		board.getChildren().clear();
//		displayCurrentPlayer();
		Canvas canvas = new Canvas(800, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Set a background color
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(0, 0, 800, 800);
		
		// Create Rooms & Tiles
		Tile tiles[][] = new Tile[16][16];
		for(int x = 0; x < 16; x++) {
			for(int y = 0; y < 16; y++) {
				if(x == 0){
					Tile tile = new Tile(gc, x, y, null);
					tiles[x][y] = tile;
				}  if(y >= 1){
					Tile tile = new Tile(gc, x, y, tiles[x][y - 1]);
					tiles[x][y] = tile;
				}
				else {
					Tile tile = new Tile(gc, x, y, tiles[x][y]);
					tiles[x][y] = tile;
				}
			}
		}
		
		
		// Study Room Code
//		gc.setFill(Color.WHITE);
//		gc.fillRect(0, 0, 150, 150);
//		
//		gc.setFill(Color.BLACK);
//		gc.setLineWidth(3);
//		Font font = Font.font("Times New Roman", FontWeight.LIGHT, 26);
//		gc.setFont(font);
//		gc.fillText("Study", 50, 75);
		
		
		
		board.setCenter(canvas);
		
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
