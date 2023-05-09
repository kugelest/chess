package htwg.se.chess.model.BoardComponent.BoardBaseImpl

import com.google.inject.Inject
import htwg.se.chess.model.BoardComponent.SquareInterface

case class Square @Inject() (pos: String, piece: Option[Piece])
    extends SquareInterface {
  def getFile: Char = pos.head

  def getRank: Int = pos.tail.toInt

  def isFree: Boolean = piece.isEmpty

  def mannedByWhite: Boolean =
    if (piece.isDefined) piece.get.getColor.equals('w') else false

  def mannedByBlack: Boolean =
    if (piece.isDefined) piece.get.getColor.equals('b') else false

  private def getAdjacentSquare(
      adjacentCoord: String
  )(board: Board): Option[Square] = {
    board.getSquare(adjacentCoord)
  }

  def getAdjacentSquareUp = getAdjacentSquare(s"$getFile${getRank + 1}") _
  def getAdjacentSquareDown = getAdjacentSquare(s"$getFile${getRank - 1}") _
  def getAdjacentSquareLeft = getAdjacentSquare( s"${(getFile - 1).toChar}$getRank") _
  def getAdjacentSquareRight = getAdjacentSquare( s"${(getFile + 1).toChar}$getRank") _
  def getAdjacentSquareUpLeft = getAdjacentSquare( s"${(getFile - 1).toChar}${getRank + 1}") _
  def getAdjacentSquareUpRight = getAdjacentSquare( s"${(getFile + 1).toChar}${getRank + 1}") _
  def getAdjacentSquareDownLeft = getAdjacentSquare( s"${(getFile - 1).toChar}${getRank - 1}") _
  def getAdjacentSquareDownRight = getAdjacentSquare( s"${(getFile + 1).toChar}${getRank - 1}") _

  // def getUp(board: Board): Option[Square] = {
  //   val newPos = s"$getFile${getRank + 1}"
  //   board.getSquare(newPos)
  // }
  //
  // def getDown(board: Board): Option[Square] = {
  //   val newPos = s"$getFile${getRank - 1}"
  //   board.getSquare(newPos)
  // }
  //
  // def getLeft(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile - 1).toChar}$getRank"
  //   board.getSquare(newPos)
  // }
  //
  // def getRight(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile + 1).toChar}$getRank"
  //   board.getSquare(newPos)
  // }
  //
  // def getUpLeft(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile - 1).toChar}${getRank + 1}"
  //   board.getSquare(newPos)
  // }
  //
  // def getUpRight(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile + 1).toChar}${getRank + 1}"
  //   board.getSquare(newPos)
  // }
  //
  // def getDownLeft(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile - 1).toChar}${getRank - 1}"
  //   board.getSquare(newPos)
  // }
  //
  // def getDownRight(board: Board): Option[Square] = {
  //   val newPos = s"${(getFile + 1).toChar}${getRank - 1}"
  //   board.getSquare(newPos)
  // }

  override def toString: String = piece.getOrElse("-").toString
}
