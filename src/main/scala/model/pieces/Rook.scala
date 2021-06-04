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



  override def toString: String = {
    color match {
//      case 'w' => "\u265C"
        case 'w' => "a"
      case 'b' => "\u2656"
    }
  }

}
