package model

case class Queen(pos: String, color: Char, kind: String = "queen") extends Piece {

  override def toString: String = {
    color match {
      case 'w' => "\u265B"
      case 'b' => "\u2655"
    }
  }
}
