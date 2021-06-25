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

  def eyesUp(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesDown(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesRight(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesUpLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesUpRight(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesDownLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square]

  def eyesDownRight(square: Square, board: Board, squares: List[Square] = List()): List[Square]

}



