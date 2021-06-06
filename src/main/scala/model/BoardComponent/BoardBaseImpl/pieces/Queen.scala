package model.BoardComponent.BoardBaseImpl.pieces

import model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}

case class Queen(pos: String, color: Char, kind: String = "queen") extends Piece {

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
    val upLefts = eyesUpLeft(board.getSquare(pos).get, board)
    val upRights = eyesUpRight(board.getSquare(pos).get, board)
    val downLefts = eyesDownLeft(board.getSquare(pos).get, board)
    val downRights = eyesDownRight(board.getSquare(pos).get, board)
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights, "upLeft" -> upLefts, "upRight" -> upRights, "downLeft" -> downLefts, "downRight" -> downRights)
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265B"
      case 'b' => "\u2655"
    }
  }
}
