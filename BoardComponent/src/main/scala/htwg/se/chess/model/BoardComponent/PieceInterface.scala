package htwg.se.chess.model.BoardComponent

import com.google.inject.ImplementedBy
import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}

@ImplementedBy(classOf[Piece])
trait PieceInterface {

  def getPos: String

  def getColor: Char

  def kind: String

  def whiteMovePossible(to: String, board: Board): Boolean

  def blackMovePossible(to: String, board: Board): Boolean

  def getFile: Char

  def getRank: Int

  def convertMove(to: String): (Char, Int, Char, Int)

  def lookUp(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookDown(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookUpLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookUpRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookDownLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

  def lookDownRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square]

}
