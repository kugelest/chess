package model.BoardComponent

import model.BoardComponent.BoardBaseImpl._

trait BoardInterface {
  def getSquare(pos: String): Option[Square]

  def getPiece(pos: String): Option[Piece]

  def toString: String

  def move(from: String, to: String): Board

  def whiteMovePossible(from: String, to: String): Boolean

  def blackMovePossible(from: String, to: String): Boolean

  def startPosition(): Board

}

trait SquareInterface {
  def isFree: Boolean

}