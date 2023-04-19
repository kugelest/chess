package htwg.se.chess.model.BoardComponent.BoardBaseImpl

import com.google.inject.Inject
import htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces._
import htwg.se.chess.model.BoardComponent.PieceInterface

abstract class Piece @Inject() (pos: String, color: Char, kind: String)
    extends PieceInterface {

  def getPos: String

  def getColor: Char

  // def kind: String

  def whiteMovePossible(to: String, board: Board): Boolean

  def blackMovePossible(to: String, board: Board): Boolean

  def getFile: Char = getPos.head

  def getRank: Int = getPos.tail.toInt

  def convertMove(to: String): (Char, Int, Char, Int) = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = getPos.charAt(0)
    val origRank = getPos.charAt(1).asDigit
    (destFile, destRank, origFile, origRank)
  }

  // def eyes(lookAtNextSquare: (Board) => Option[Square])(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
  //   square.lookAtNextSquare(board) match {
  //     case Some(square) if !square.isFree =>
  //       if (!getColor.equals(square.piece.get.getColor)) squares.patch(0, List(square), 0)
  //       else squares
  //     case None => squares
  //     case Some(square) if square.isFree =>
  //       lookAtNextSquare(square, board: Board, squares.patch(0, List(square), 0))
  //   }
  // }

  def lookUp(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareUp(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookUp(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookDown(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareDown(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookDown(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareRight(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookUpLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareUpLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookUpLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookUpRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareUpRight(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookUpRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookDownLeft(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareDownLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookDownLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def lookDownRight(
      square: Square,
      board: Board,
      squares: List[Square] = List()
  ): List[Square] = {
    square.getAdjacentSquareDownRight(board) match {
      case Some(square) if !square.isFree =>
        if (!getColor.equals(square.piece.get.getColor))
          squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        lookDownRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }
}

object Piece {
  def apply(kind: String, pos: String, color: Char): Piece = kind match {
    case "king"   => King(pos, color)
    case "queen"  => Queen(pos, color)
    case "rook"   => Rook(pos, color)
    case "knight" => Knight(pos, color)
    case "bishop" => Bishop(pos, color)
    case "pawn"   => Pawn(pos, color)
  }
}
