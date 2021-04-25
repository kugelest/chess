package model

case class Rook(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    board.removePiece(pos).setPiece(to, Rook(to, color))
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
