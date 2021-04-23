package model

case class Queen(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265B"
      case 'b' => "\u2655"
    }
  }
}
