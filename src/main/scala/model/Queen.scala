package model

case class Queen(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    board.removePiece(pos).setPiece(Queen(to, color))
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265B"
      case 'b' => "\u2655"
    }
  }
}
