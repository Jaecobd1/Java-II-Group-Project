# Clue-like game

## Java II Group Project

### Created by: Jake Dobler, Genevieve Matthews, Garrett Kellogg, Daniel Reyes

Work Distribution:
Jake Dobler - init the project and create classes Gameboard/ Tiles (GUI & logic)

Genevieve Matthews - Clues (Cards)

Daniel Reyes - Assumptions page (making a guess)

Garret Kellogg - Rooms & Players (GUI & Logic)

Classes:

GameBoard – Handles the functionality of the game, and composes the tiles. This includes managing the current player, randomly generates items on tiles and game rules. Also includes the GUI elements.

Tiles – A linked list of moveable spots for the players

Ball Room

Billiard Room

Conservatory

Dining Room

Hall

Kitchen

Lounge

Library

Study

Suspects – Store information relating to the players of the game, each player is given their own score card (as seen below)

Mrs. White

Mrs. Peacock

Professor Plum

Colonel Mustard

Miss Scarlett

Reverend Green

Items/Clues – Players can pick up items and use them

Knife

Revolver

Rope

Wrench

Candlestick

Lead Pipe

Rules:

Player(s) select character(s)

Assign items at random to rooms (max 1 item per room)

Shuffle Weapons, Rooms, and Suspects. Select one at random from each category and store as “Secret Case File" (correct murder combo).

If multiplayer, players take turns moving spaces determined by dice rolls to explore the house.

For single player, player may choose which room to explore to discover clues.

When in a room, player(s) can make an accusation (Suspect, Weapon, Location: ex: “Colonel Mustard, with the Candlestick, in the Billiard Room”), but only for the room they are currently in.

If incorrect, information that does not match the “Secret Case File” is revealed as false. In the physical game, each player has a note pad to cross off incorrect elements (process of elimination).

Player wins when all three elements (Suspect, Weapon, Location) are correct. Otherwise other players have a chance to guess.

Repeat turn cycle (player moves, chance to guess, correct/incorrect info revealed) until full correct guess is made.
