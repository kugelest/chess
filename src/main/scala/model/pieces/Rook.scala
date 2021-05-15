package model.pieces

import model.{Board, Square}

case class Rook(pos: String, color: Char, kind: String = "rook") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    color match {
      case 'w' => eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    color match {
      case 'b' => eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  def eyesOn(board: Board): Map[String, List[Square]] = {
    val ups = eyesUp(board.getSquare(pos).get, board)
    val downs = eyesDown(board.getSquare(pos).get, board)
    val lefts = eyesLeft(board.getSquare(pos).get, board)
    val rights = eyesRight(board.getSquare(pos).get, board)
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights)
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

  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
