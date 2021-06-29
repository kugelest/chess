package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}

case class Queen(getPos: String, getColor: Char, kind: String = "queen") extends Piece(getPos, getColor, kind) {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    getColor match {
      case 'w' => eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    getColor match {
      case 'b' => eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  def eyesOn(board: Board): Map[String, List[Square]] = {
    val ups = eyesUp(board.getSquare(getPos).get, board)
    val downs = eyesDown(board.getSquare(getPos).get, board)
    val lefts = eyesLeft(board.getSquare(getPos).get, board)
    val rights = eyesRight(board.getSquare(getPos).get, board)
    val upLefts = eyesUpLeft(board.getSquare(getPos).get, board)
    val upRights = eyesUpRight(board.getSquare(getPos).get, board)
    val downLefts = eyesDownLeft(board.getSquare(getPos).get, board)
    val downRights = eyesDownRight(board.getSquare(getPos).get, board)
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights, "upLeft" -> upLefts, "upRight" -> upRights, "downLeft" -> downLefts, "downRight" -> downRights)
  }

  override def toString: String = {
    getColor match {
      case 'w' => "♕"
      case 'b' => "♛"
    }
  }
}
