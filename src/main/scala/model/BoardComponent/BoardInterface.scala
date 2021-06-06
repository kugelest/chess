package model.BoardComponent

import model.BoardComponent.BoardBaseImpl._

trait BoardInterface {
  def getSquare(pos: String): Option[Square]

  def getPiece(pos: String): Option[Piece]

  def boardToString: String

  def squareIsFree: Boolean
}

trait SquareInterface {

}
