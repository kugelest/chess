package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece}

case class King(getPos: String, getColor: Char, kind: String = "king")
    extends Piece(getPos, getColor, kind) {

  override def whiteMovePossible(to: String, board: Board): Boolean = true

  override def blackMovePossible(to: String, board: Board): Boolean = true

  override def toString: String = {
    getColor match {
      case 'w' => "♔"
      case 'b' => "♚"
    }
  }
}
