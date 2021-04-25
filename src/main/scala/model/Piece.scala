package model

trait Piece {
  def color: Char

  def move(from: String, to: String, board: Board): Board = {
    board.removePiece(from).setPiece(to, Pawn(color))
  }
}
