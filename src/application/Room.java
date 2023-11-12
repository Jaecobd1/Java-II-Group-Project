package application;

public class Room extends Clue{

	public Room(String name) {
		super(name);
	}
// The following code section is already in the Game Board section. I am not sure we need to have a separate java file for the rooms, but if so it would be appropriate to have it here.
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
}
