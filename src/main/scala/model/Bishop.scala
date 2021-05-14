package model

case class Bishop(pos: String, color: Char, kind: String = "bishop") extends Piece {


  override def toString: String = {
    color match {
      case 'w' => "\u265D"
      case 'b' => "\u2657"
    }
  }

  override def whiteMovePossible(to: String, board: Board): Boolean = true
  override def blackMovePossible(to: String, board: Board): Boolean = true
}
