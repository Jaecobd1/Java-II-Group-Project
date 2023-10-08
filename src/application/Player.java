package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player {
	String name;
	Player next;
	Paint color;
	Tile currentTile;
	
	public Player(String name, GraphicsContext gc, Paint color, Tile currentTile) {
		
		this.color = color;
		this.currentTile = currentTile;
		gc.setFill(color);
		gc.fillOval((currentTile.x * 50) + 10, (currentTile.y * 50) + 10, 25, 25);
	}
	
	public void movePlayer(Tile currentTile) {
		this.currentTile = currentTile;
	}
}
