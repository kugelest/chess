package model.BoardComponent

import model.BoardComponent.BoardBaseImpl.pieces._
import model.BoardComponent.BoardBaseImpl.{Board, Square}

trait Piece {
  def pos: String

  def color: Char

  def kind: String

  def whiteMovePossible(to: String, board: Board): Boolean

  def blackMovePossible(to: String, board: Board): Boolean

  def getFile: Char = pos.head

  def getRank: Int = pos.tail.toInt

  def convertMove(to: String): (Char, Int, Char, Int) = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = pos.charAt(0)
    val origRank = pos.charAt(1).asDigit
    (destFile, destRank, origFile, origRank)
  }

  def eyesUp(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getUp(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesUp(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesDown(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getDown(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesDown(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesRight(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getRight(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesUpLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getUpLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesUpLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesUpRight(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getUpRight(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesUpRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesDownLeft(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getDownLeft(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesDownLeft(square, board: Board, squares.patch(0, List(square), 0))
    }
  }

  def eyesDownRight(square: Square, board: Board, squares: List[Square] = List()): List[Square] = {
    square.getDownRight(board) match {
      case Some(square) if !square.isFree =>
        if (!color.equals(square.piece.get.color)) squares.patch(0, List(square), 0)
        else squares
      case None => squares
      case Some(square) if square.isFree =>
        eyesDownRight(square, board: Board, squares.patch(0, List(square), 0))
    }
  }
}

object Piece {
 def apply(kind: String, pos: String, color: Char): Piece = kind match {
   case "king" => King(pos, color)
   case "queen" => Queen(pos, color)
   case "rook" => Rook(pos, color)
   case "knight" => Knight(pos, color)
   case "bishop" => Bishop(pos, color)
   case "pawn" => Pawn(pos, color)
 }
}

