package model

case class King(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265A"
      case 'b' => "\u2654"
    }
  }
}
