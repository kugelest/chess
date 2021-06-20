package model.BoardComponent.BoardBaseImpl.pieces

import com.google.inject.Inject
import model.BoardComponent.BoardBaseImpl.{Board, Piece}
import model.BoardComponent.PieceInterface

case class King (getPos: String, getColor: Char, kind: String = "king") extends Piece(getPos, getColor, kind) {

  override def whiteMovePossible(to: String, board: Board): Boolean = true

  override def blackMovePossible(to: String, board: Board): Boolean = true

  override def toString: String = {
    getColor match {
      case 'w' => "\u265A"
      case 'b' => "\u2654"
    }
  }
}
