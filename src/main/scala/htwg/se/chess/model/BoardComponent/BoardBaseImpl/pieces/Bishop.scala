package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}

case class Bishop(getPos: String, getColor: Char, kind: String = "bishop") extends Piece(getPos, getColor, kind) {

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
    val upLefts = lookUpLeft(board.getSquare(getPos).get, board)
    val upRights = lookUpRight(board.getSquare(getPos).get, board)
    val downLefts = lookDownLeft(board.getSquare(getPos).get, board)
    val downRights = lookDownRight(board.getSquare(getPos).get, board)
    Map("upLeft" -> upLefts, "upRight" -> upRights, "downLeft" -> downLefts, "downRight" -> downRights)
  }

  override def toString: String = {
    getColor match {
      case 'w' => "♗"
      case 'b' => "♝"
    }
  }
}
