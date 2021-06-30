# Chess

Main
\
[![Build Status](https://travis-ci.com/kugelest/chess.svg?branch=main&kill_cache=1)](https://travis-ci.com/kugelest/chess)
[![Coverage Status](https://coveralls.io/repos/github/kugelest/chess/badge.svg?branch=main&kill_cache=1)](https://coveralls.io/github/kugelest/chess?branch=main&kill_cache=1)

Developer
\
[![Build Status](https://travis-ci.com/kugelest/chess.svg?branch=developer&kill_cache=1)](https://travis-ci.com/kugelest/chess)
[![Coverage Status](https://coveralls.io/repos/github/kugelest/chess/badge.svg?branch=developer&kill_cache=1)](https://coveralls.io/github/kugelest/chess?branch=developer&kill_cache=1)

## Rules

Basic Rules
- King can move exactly one square horizontally, vertically or diagonally
- Queen can move any number of vacant squares diagonally, vertically or diagonally
- Rook can move any number of vacant squares diagonally or vertically
- Bishop can move any number of vacant squares in any diagonal direction
- Knight can move one square along any rank or file and then at an angle
- Pawns can move forward one square, if that square is unoccupied

### How to Play

TUI-Commands:
- "empty"           => creates empty chessboard
- "start"           => places all pieces on the chessboard
- "move from to"    => make a move (e.g "move d2 d4")
- "undo"            => undo last move
- "redo"            => redo last move
- "save"            => save the game
- "load"            => load the game
- "quit"            => exit the program

Gui:
- Menu with {"New", "Start", "undo", "redo", "save", "load", "quit"}
- make a move by clicking on a piece and then by clicking the square you want to move to
  (Currently GUI is not updating, but the move is played out in the TUI)