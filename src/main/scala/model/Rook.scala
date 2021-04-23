package model

case class Rook(color: Char) extends Piece {
  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }
}
