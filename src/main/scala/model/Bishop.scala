package model

case class Bishop(pos: String, color: Char, kind: String = "bishop") extends Piece {


  override def toString: String = {
    color match {
      case 'w' => "\u265D"
      case 'b' => "\u2657"
    }
  }
}
