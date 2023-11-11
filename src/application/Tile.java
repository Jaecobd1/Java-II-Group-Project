package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Created by Jake Dobler Nov 11 2023

public class Tile {
	// Reference to other tiles
	Tile prev, next, above, below;
	Clue clueOnTile = null;
	int x, y;

	// Creates a new "linked list" tile
	public Tile(GraphicsContext gc, int x, int y, Tile prev) {
		this.x = x;
		this.y = y;
		if (this.prev == null) {
			this.next = null;
		} else {
			this.prev = prev;
			this.prev.next = this;
		}

		draw(gc, x * 50, y * 50);

	}

	// Used for tiles that are not the first in a row
	public Tile(GraphicsContext gc, int x, int y, Tile prev, Tile above) {
		if (this.prev == null) {
			this.next = null;
		} else {
			this.prev = prev;
			this.prev.next = this;
		}

		this.above.below = this;

		draw(gc, x * 50, y * 50);

	}

	// Used to draw tiles on the board
	private void draw(GraphicsContext gc, int x, int y) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.strokeRect(x, y, 50, 50);
	}

}
