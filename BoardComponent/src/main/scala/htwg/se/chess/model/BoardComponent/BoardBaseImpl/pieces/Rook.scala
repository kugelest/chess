package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece, Square}

case class Rook(getPos: String, getColor: Char, kind: String = "rook")
    extends Piece(getPos, getColor, kind) {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    getColor match {
      case 'w' =>
        eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    getColor match {
      case 'b' =>
        eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
      case _ => false
    }
  }

  // def movePossible(color: Char)(to: String, board: Board): Boolean = {
  //   getColor match {
  //     case color => eyesOn(board).values.flatten.toList.contains(board.getSquare(to).get)
  //     case _ => false
  //   }
  // }
  // override def whiteMovePossible = movePossible('w') _
  // override def blackMovePossible = movePossible('b') _

  def eyesOn(board: Board): Map[String, List[Square]] = {
    val ups = lookUp(board.getSquare(getPos).get, board)
    val downs = lookDown(board.getSquare(getPos).get, board)
    val lefts = lookLeft(board.getSquare(getPos).get, board)
    val rights = lookRight(board.getSquare(getPos).get, board)
    Map("up" -> ups, "down" -> downs, "left" -> lefts, "right" -> rights)
  }

  override def toString: String = {
    getColor match {
      case 'w' => "♖"
      case 'b' => "♜"
    }
  }

}
