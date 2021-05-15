package model.pieces

import model.Board

case class Knight(pos: String, color: Char, kind: String = "knight") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    color match {
      case 'w' =>
        if (board.getSquare(to).get.isFree || board.getSquare(to).get.mannedByBlack) {
          if (destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)) {
            if (destRank.equals(origRank + 2) || destRank.equals(origRank - 2)) {
              true
            } else false
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)) {
            if (destRank.equals(origRank + 1) || destRank.equals(origRank - 1)) {
              true
            } else false
          } else false
        } else false
      case _ => false
    }
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    color match {
      case 'b' =>
        if (board.getSquare(to).get.isFree || board.getSquare(to).get.mannedByWhite) {
          if (destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)) {
            if (destRank.equals(origRank + 2) || destRank.equals(origRank - 2)) {
              true
            } else false
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)) {
            if (destRank.equals(origRank + 1) || destRank.equals(origRank - 1)) {
              true
            } else false
          } else false
        } else false
      case _ => false
    }
  }


  override def toString: String = {
    color match {
      case 'w' => "\u265E"
      case 'b' => "\u2658"
    }
  }
}
