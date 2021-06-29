package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece}

case class Knight(getPos: String, getColor: Char, kind: String = "knight") extends Piece(getPos, getColor, kind) {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    if (getColor.equals('w') && (board.getSquare(to).get.isFree || board.getSquare(to).get.mannedByBlack)) {
      knightMove(to)
    } else false
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    if (getColor.equals('b') && (board.getSquare(to).get.isFree || board.getSquare(to).get.mannedByWhite)) {
      knightMove(to)
    } else false
  }

  def knightMove(to: String): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    if (destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)) {
      if (destRank.equals(origRank + 2) || destRank.equals(origRank - 2)) {
        true
      } else false
    } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)) {
      if (destRank.equals(origRank + 1) || destRank.equals(origRank - 1)) {
        true
      } else false
    } else false
  }


  override def toString: String = {
    getColor match {
      case 'w' => "♘"
      case 'b' => "♞"
    }
  }
}
