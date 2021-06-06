package model.BoardComponent.BoardBaseImpl.pieces

import model.BoardComponent.BoardBaseImpl.{Board, Piece}

case class King(pos: String, color: Char, kind: String = "king") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = true

  override def blackMovePossible(to: String, board: Board): Boolean = true

  override def toString: String = {
    color match {
      case 'w' => "\u265A"
      case 'b' => "\u2654"
    }
  }
}
