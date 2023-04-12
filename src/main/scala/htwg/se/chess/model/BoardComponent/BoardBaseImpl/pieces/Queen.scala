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
    val ups = lookUp(board.getSquare(getPos).get, board)
    val downs = lookDown(board.getSquare(getPos).get, board)
    val lefts = lookLeft(board.getSquare(getPos).get, board)
    val rights = lookRight(board.getSquare(getPos).get, board)
    val upLefts = lookUpLeft(board.getSquare(getPos).get, board)
    val upRights = lookUpRight(board.getSquare(getPos).get, board)
    val downLefts = lookDownLeft(board.getSquare(getPos).get, board)
    val downRights = lookDownRight(board.getSquare(getPos).get, board)
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights, "upLeft" -> upLefts, "upRight" -> upRights, "downLeft" -> downLefts, "downRight" -> downRights)
  }

  override def toString: String = {
    getColor match {
      case 'w' => "♕"
      case 'b' => "♛"
    }
  }
}

