package model

case class Bishop(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265D"
      case 'b' => "\u2657"
    }
  }
}
