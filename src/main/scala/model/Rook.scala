package model

case class Rook(pos: String, color: Char, kind: String = "rook") extends Piece {

  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
