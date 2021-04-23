package model

case class Pawn(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265F"
      case 'b' => "\u2659"
    }
  }
}
