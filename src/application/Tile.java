package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Started By Jake Dobler
public class Tile {
	// Reference to other tiles
	Tile prev = null;
	Tile next = null;
	Clue clueOnTile = null;
	
	// Blank Tile (Not useful except for very first tile created)
	public Tile(GraphicsContext gc, int x, int y, Tile prev) {
		if(this.prev == null) {
			this.next = null;
		}else {
			this.prev = prev;
			this.prev.next = this;
		}
		
		draw(gc, x * 50, y * 50);
		
	}
	
	private void draw(GraphicsContext gc, int x, int y) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.strokeRect(x, y, 50, 50);
	}
	

}
