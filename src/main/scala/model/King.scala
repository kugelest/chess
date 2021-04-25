package model

case class King(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    board.removePiece(pos).setPiece(to, King(to, color))
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265A"
      case 'b' => "\u2654"
    }
  }
}
