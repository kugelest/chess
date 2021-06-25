package htwg.se.chess.model.BoardComponent

import htwg.se.chess.model.BoardComponent.BoardBaseImpl._

trait BoardInterface {
  def setPiece(piece: Piece): Board

  def getSquare(pos: String): Option[Square]

  def toString: String

  def move(from: String, to: String): Board

  def whiteMovePossible(from: String, to: String): Boolean

  def blackMovePossible(from: String, to: String): Boolean

  def startPosition(): Board

  def getPiece(pos: String): Option[PieceInterface]

}



