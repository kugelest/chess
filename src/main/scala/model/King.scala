package model

case class King(pos: String, color: Char, kind: String = "king") extends Piece {


  override def toString: String = {
    color match {
      case 'w' => "\u265A"
      case 'b' => "\u2654"
    }
  }
}
