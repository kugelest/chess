package model

case class Queen(pos: String, color: Char, kind: String = "queen") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = true
  override def blackMovePossible(to: String, board: Board): Boolean = true

  override def toString: String = {
    color match {
      case 'w' => "\u265B"
      case 'b' => "\u2655"
    }
  }
}
