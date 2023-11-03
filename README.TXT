PROJECT TITLE: Conway's Game of Life
VERSION or DATE: 23/10/23
AUTHOR: Ultan Larkin

John Conway's Game of Life is a cellular automaton created by John Conway. 
It requires no players as it evolves after each tick meaning each state is determined by its
intial state.

INSTRUCTIONS:

In this game, the only input required is a set of coordinates at the beginning of the game.
Each evolution is determined by a set of rules which tells which which cells should live on, 
die or be born.
Every cell interacts with its 'neighbours' (adjacent cells) to figure out the state of that 
cell in the next evolution.
Here are the rules:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.

2. Any live cell with two or three live neighbours lives on to the next generation.

3. Any live cell with more than three live neighbours dies, as if by overpopulation.

4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

In my version of the game, I have introduced loadable files where the player can choose to load
a predetermined set of of coordinates in order to make the experience easier to use.
If the player does not want to load a file, they can place living cells manually, using
simple coordinates to do so.
Once the player has placed all their cells, they are given an option to save their setup as
a new 'CSV' file which will simply record all their previous coordinates in a new file
located in the directory.
They will then choose how many generations will play out, then the program will display 
each generation respectively.
