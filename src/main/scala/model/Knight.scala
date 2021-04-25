package model

case class Knight(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    board.removePiece(pos).setPiece(to, Knight(to, color))
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265E"
      case 'b' => "\u2658"
    }
  }
}
