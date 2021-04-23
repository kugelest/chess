package model

case class Knight(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265E"
      case 'b' => "\u2658"
    }
  }
}
