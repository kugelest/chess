package model.pieces

import model.Board

case class Rook(pos: String, color: Char, kind: String = "rook") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = true

  override def blackMovePossible(to: String, board: Board): Boolean = true

  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
