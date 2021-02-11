# Battleship
Battleship (also called Battleships or Sea Battle) is a two-player strategy game whose history traces back to the First World War. It started off as a pencil and paper game, until Milton Bradley coined the rules and published the game. Fun fact: it was one of the first games to be produced as a computer game in 1979!

You can find more about this game on [this page in Wikipedia](https://en.wikipedia.org/wiki/Battleship_(game)).

## Table of Contents
* [About this program](#about-this-program)
* [Technologies](#technologies)
* [Program Description](#program-description)
* [Example](#example)

## About this program
This project is a solution to the problem of JetBrains Academy - "Battleship Game".

This version of the game has original rules written by Milton Bradley.

You have a 10×10 game field and five ships to arrange on that field. The ships can be placed horizontally or vertically but not diagonally across the grid spaces; the ships should not cross or touch each other.

The goal is to sink all the ships of the opponent before your opponent does this to you.

## Technologies
- JDK 8

## Program Description
1. The game field is 10x10 in size.
	* The symbol '`~`' denotes the fog of war: the unknown area on the opponent's field and the yet untouched area on your field.
	* The symbol '`O`' denotes a cell with your ship.
	* The symbol '`X`' denotes that the ship was hit.
	* The symbol '`M`' signifies a miss.
2. You have 5 ships:
	| No. | Class of ship    | Size |
	| --- |:----------------:| ----:|
	|  1  | Aircraft Carrier |   5  |
	|  2  | Battleship       |   4  |
	|  3  | Submarine        |   3  |
	|  4  | Cruiser          |   3  |
	|  5  | Destroyer        |   2  |
3. The coordinate has the form: a capital letter (A-J) + a number (1 - 10). Ex. "A1".
4. Enter the requested data and confirm the selection by pressing **Enter** button.

## Example
The greater-than symbol followed by a space ( **>** ) represents the user input. Note that it's not part of the input.

```
Player 1, place your ships on the game field

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Aircraft Carrier (5 cells):

> F3 F7

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Battleship (4 cells):

> A1 D1

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O ~ ~ ~ ~ ~ ~ ~ ~ ~
C O ~ ~ ~ ~ ~ ~ ~ ~ ~
D O ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Submarine (3 cells):

> J7 J10

Error! Wrong length of the Submarine! Try again:

> J10 J8

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O ~ ~ ~ ~ ~ ~ ~ ~ ~
C O ~ ~ ~ ~ ~ ~ ~ ~ ~
D O ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ O O O

Enter the coordinates of the Cruiser (3 cells):

> B9 D8

Error! Wrong ship location! Try again:

> B9 D9

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O ~ ~ ~ ~ ~ ~ ~ O ~
C O ~ ~ ~ ~ ~ ~ ~ O ~
D O ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ O O O

Enter the coordinates of the Destroyer (2 cells):

> E6 D6

Error! You placed it too close to another one. Try again:

> I2 J2

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O ~ ~ ~ ~ ~ ~ ~ O ~
C O ~ ~ ~ ~ ~ ~ ~ O ~
D O ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ O ~ ~ ~ ~ ~ ~ ~ ~
J ~ O ~ ~ ~ ~ ~ O O O

Press Enter and pass the move to another player
...
Player 2, place your ships to the game field

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Aircraft Carrier (5 cells):

> H2 H6

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ O O O O O ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Battleship (4 cells):

> F3 F6

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ O O O O O ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Submarine (3 cells):

> H8 F8

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O ~ O ~ ~
G ~ ~ ~ ~ ~ ~ ~ O ~ ~
H ~ O O O O O ~ O ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

...

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ O ~ ~
D ~ ~ ~ O O O ~ O ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O ~ O ~ ~
G ~ ~ ~ ~ ~ ~ ~ O ~ ~
H ~ O O O O O ~ O ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Press Enter and pass the move to another player
...

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
---------------------
  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O ~ ~ ~ ~ ~ ~ ~ O ~
C O ~ ~ ~ ~ ~ ~ ~ O ~
D O ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ O ~ ~ ~ ~ ~ ~ ~ ~
J ~ O ~ ~ ~ ~ ~ O O O

Player 1, it's your turn:

> I3

You missed!
Press Enter and pass the move to another player
...

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
---------------------
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ O ~ ~
D ~ ~ ~ O O O ~ O ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O ~ O ~ ~
G ~ ~ ~ ~ ~ ~ ~ O ~ ~
H ~ O O O O O ~ O ~ ~
I ~ ~ M ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Player 2, it's your turn:

> A1

You hit a ship!
Press Enter and pass the move to another player
...
```
