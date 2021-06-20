package model.BoardComponent.BoardBaseImpl.pieces

import com.google.inject.Inject
import model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}
import model.BoardComponent.PieceInterface

case class Rook (getPos: String, getColor: Char, kind: String = "rook") extends Piece(getPos, getColor, kind) {

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
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights)
  }



  override def toString: String = {
    getColor match {
      case 'w' => "\u265C"
      case 'b' => "\u2656"
    }
  }

}
