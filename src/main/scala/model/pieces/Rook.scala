package model.pieces

import model.{Board, Square}

case class Rook(pos: String, color: Char, kind: String = "rook") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
  }

  override def blackMovePossible(to: String, board: Board): Boolean = true

  def eyesOn(board: Board): Map[String, List[Square]] = {
    val (file, rank) = (pos.charAt(0), pos.charAt(1).asDigit)
    val (ups, downs) = (up(board, file, rank+1, List()), down(board, file, rank-1, List()))
    Map("up" -> ups, "down" -> downs)
  }

  def up(board: Board, file: Char, rank: Int, squares: List[Square]): List[Square] = {
    val square = board.getSquare(file.toString.concat(rank.toString))
    square match {
      case Some(square) if !square.isFree =>  squares
      case None => squares
      case Some(square) if square.isFree => up(board, file, rank+1, squares.patch(0, List(square), 0))
    }
  }

  def down(board: Board, file: Char, rank: Int, squares: List[Square]): List[Square] = {
    val square = board.getSquare(file.toString.concat(rank.toString))
    square match {
      case Some(square) if !square.isFree =>  squares
      case None => squares
      case Some(square) if square.isFree => down(board, file, rank-1, squares.patch(0, List(square), 0))
    }
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
