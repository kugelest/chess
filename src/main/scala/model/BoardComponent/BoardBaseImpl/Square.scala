package model.BoardComponent.BoardBaseImpl

import model.BoardComponent.{Piece, SquareInterface}

case class Square(pos: String, piece: Option[Piece]) extends SquareInterface {
  def getFile: Char = pos.head

  def getRank: Int = pos.tail.toInt

  def isFree: Boolean = piece.isEmpty

  def mannedByWhite: Boolean = if (piece.isDefined) piece.get.color.equals('w') else false

  def mannedByBlack: Boolean = if (piece.isDefined) piece.get.color.equals('b') else false

  def getUp(board: Board): Option[Square] = {
    val newPos = s"$getFile${getRank + 1}"
    board.getSquare(newPos)
  }

  def getDown(board: Board): Option[Square] = {
    val newPos = s"$getFile${getRank - 1}"
    board.getSquare(newPos)
  }

  def getLeft(board: Board): Option[Square] = {
    val newPos = s"${(getFile - 1).toChar}$getRank"
    board.getSquare(newPos)
  }

  def getRight(board: Board): Option[Square] = {
    val newPos = s"${(getFile + 1).toChar}$getRank"
    board.getSquare(newPos)
  }

  def getUpLeft(board: Board): Option[Square] = {
    val newPos = s"${(getFile - 1).toChar}${getRank + 1}"
    board.getSquare(newPos)
  }

  def getUpRight(board: Board): Option[Square] = {
    val newPos = s"${(getFile + 1).toChar}${getRank + 1}"
    board.getSquare(newPos)
  }

  def getDownLeft(board: Board): Option[Square] = {
    val newPos = s"${(getFile - 1).toChar}${getRank - 1}"
    board.getSquare(newPos)
  }

  def getDownRight(board: Board): Option[Square] = {
    val newPos = s"${(getFile + 1).toChar}${getRank - 1}"
    board.getSquare(newPos)
  }

  override def toString: String = piece.getOrElse("-").toString
}
