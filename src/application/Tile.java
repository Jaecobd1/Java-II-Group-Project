package application;
// Started By Jake Dobler
public class Tile {
	// Reference to other tiles
	Tile prev = null;
	Tile next = null;
	Clue clueOnTile = null;
	
	// Blank Tile (Not useful except for very first tile created)
	public Tile() {
		this.prev = null;
		this.next = null;
	}
	

}
