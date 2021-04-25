package model

case class Bishop(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    board.removePiece(pos).setPiece(to, Bishop(to, color))
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265D"
      case 'b' => "\u2657"
    }
  }
}
