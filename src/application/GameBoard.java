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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Created by Jake Dobler Nov 11 2023

public class GameBoard {
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
	BorderPane board;
	Player currentPlayer;

	// Creates a GameBoard and displays the start screen
	public GameBoard(BorderPane board) {
		this.board = board;
	}

	// Show a start screen
	// Allow user to move to player select
	public void displayStartScreen() {

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

	// Starts the game and displays the game board
	private void startGame() {

		// Create instances of all of the possible
		// suspects, rooms and weapons
		Suspect suspectCards[] = new Suspect[6];
		int suspectCount = 0;
		for (String suspect : suspects) {
			suspectCards[suspectCount] = new Suspect(suspect);
			suspectCount++;
		}
		Weapon weaponCards[] = new Weapon[6];
		int weaponCount = 0;
		for (String weapon : weapons) {
			weaponCards[weaponCount] = new Weapon(weapon);
			weaponCount++;
		}
		Room roomCards[] = new Room[9];
		int roomCount = 0;
		for (String room : rooms) {
			roomCards[roomCount] = new Room(room);
			roomCount++;
		}

		// Select a suspect, weapon, and room **Important part of game**
		for (Suspect suspect : suspectCards) {
			System.out.println(suspect.clueName);
		}
		this.setUpGameBoard();

	}

	// Might bring this back later if we decide to have more than one real player
	// private void displayPlayerSelect() {
	// Label playersLabel = new Label("Number of Players:");
	// playersLabel.getStyleClass().add("title");
	// board.setTop(playersLabel);
	// String playerOptions[] = {"1", "2", "3", "4"};
	// ComboBox<String> cmb = new
	// ComboBox(FXCollections.observableArrayList(playerOptions));
	// board.setCenter(cmb);
	// Button play = new Button("Play!");
	//
	// board.setBottom(play);
	//
	// play.setOnAction(e->{
	// int numOfPlayers = Integer.parseInt(cmb.getValue());
	// createPlayers(numOfPlayers);
	// });
	//
	// }

	// Add Rooms to GUI (Should Rooms just be oversized tiles) I.E. Rooms extend
	// tile?

	// Create tiles representing moveable positions. Maybe everywhere there is not a
	// room?
	// (there aren't moveable spots in the rooms of the real game)

	// For each clue group - 1 Add random clues to tiles
	// For randomness I would shuffle the list before the for loops

	// Functions for managing players and gameplay
	private void nextPlayer() {
		currentPlayer = currentPlayer.next;
	}

	// refresh the visuals on the game board after a player moves
	private void updateGameBoard() {
	    
	}
	

	// Creates a linked list of tiles
	private void setUpGameBoard() {
		board.getChildren().clear();
		// displayCurrentPlayer();
		Canvas canvas = new Canvas(750, 750);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		// Set a background color
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(0, 0, 800, 800);

		// Create Tiles
		Tile tiles[][] = new Tile[15][15];
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				if (x == 0) {
					Tile tile = new Tile(gc, x, y, null);
					tiles[x][y] = tile;
				}
				if (y >= 1) {
					Tile tile = new Tile(gc, x, y, tiles[x][y - 1]);
					tiles[x][y] = tile;
				} else {
					Tile tile = new Tile(gc, x, y, tiles[x][y]);
					tiles[x][y] = tile;
				}
			}
		}

		// Remove Tiles where rooms go
		// Study
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 3; y++)
				tiles[x][y] = null;

		// Hall
		for (int x = 6; x < 10; x++)
			for (int y = 0; y < 3; y++)
				tiles[x][y] = null;
		// Lounge
		for (int x = 13; x < 15; x++)
			for (int y = 0; y < 3; y++)
				tiles[x][y] = null;
		// Library
		for (int x = 0; x < 4; x++)
			for (int y = 5; y < 6; y++)
				tiles[x][y] = null;
		// Billard Room
		for (int x = 0; x < 4; x++)
			for (int y = 8; y < 9; y++)
				tiles[x][y] = null;

		// Ball Room
		for (int x = 6; x < 10; x++)
			for (int y = 11; y < 15; y++)
				tiles[x][y] = null;
		// Kitchen
		for (int x = 12; x < 15; x++)
			for (int y = 12; y < 15; y++)
				tiles[x][y] = null;
		// Clue Room
		for (int x = 6; x < 9; x++)
			for (int y = 6; y < 8; y++)
				tiles[x][y] = null;

		// Conservatory
		for (int x = 0; x < 4; x++)
			for (int y = 12; y < 15; y++)
				tiles[x][y] = null;

		// Create Rooms (I think this could easily be refactored but for now
		// its fine)
		// Study
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 200, 150);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		Font font = Font.font("Times New Roman", FontWeight.LIGHT, 26);
		gc.setFont(font);
		gc.fillText("Study", 50, 75);

		// Hall
		gc.setFill(Color.WHITE);
		gc.fillRect(300, 0, 200, 250);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Hall", 400, 125);

		// Lounge
		gc.setFill(Color.WHITE);
		gc.fillRect(600, 0, 200, 200);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Lounge", 650, 75);
		// Library
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 250, 200, 100);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Library", 50, 300);
		// Billiard Room
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 400, 200, 100);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Billiard \nRoom", 50, 450);

		// Ball Room
		gc.setFill(Color.WHITE);
		gc.fillRect(300, 500, 200, 250);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Ball \nRoom", 350, 625);

		// Kitchen
		gc.setFill(Color.WHITE);
		gc.fillRect(600, 550, 150, 200);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Kitchen", 650, 675);

		// Dining Room
		gc.setFill(Color.WHITE);
		gc.fillRect(550, 250, 200, 250);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Dining \nRoom", 625, 375);
		// Clue Room
		gc.setFill(Color.WHITE);
		gc.fillRect(300, 300, 200, 150);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.fillText("Clue!?", 375, 375);

		// Conservatory
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 600, 200, 150);
		font = Font.font("Times New Roman", FontWeight.LIGHT, 20);
		gc.setFill(Color.BLACK);
		gc.setLineWidth(3);
		gc.setFont(font);
		gc.fillText("Conservatory", 50, 675);

		// Show Players
		Player[] playerList = new Player[6];
		for (int i = 0; i < suspects.length; i++) {
			Paint[] colors = {
					Color.WHITE,
					Color.LIGHTBLUE,
					Color.PLUM,
					Color.YELLOW,
					Color.DARKRED,
					Color.DARKOLIVEGREEN,
			};
			Tile locations[] = {
					tiles[0][3],
					tiles[0][10],
					tiles[4][0],
					tiles[0][11],
					tiles[11][0],
					tiles[4][14],
			};
			Player player = new Player(suspects[i], gc, colors[i], locations[i]);
			playerList[i] = player;
		}
		board.setCenter(canvas);
	}
	
}
