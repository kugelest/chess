package model

case class Pawn(pos: String, color: Char, kind: String = "pawn") extends Piece {


  def whiteMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    if (color.equals('w') && destFile.equals(origFile) && destRank.equals(origRank + 1) && board.getSquare(to).isFree
      ||color.equals('w') && destFile.equals((origFile+1).toChar) && destRank.equals(origRank + 1) && board.getSquare(to).mannedByBlack()
      ||color.equals('w') && destFile.equals((origFile-1).toChar) && destRank.equals(origRank + 1) && board.getSquare(to).mannedByBlack()) {
      true
    } else false
  }

  def blackMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    if (color.equals('b') && destFile.equals(origFile) && destRank.equals(origRank - 1) && board.getSquare(to).isFree
      ||color.equals('b') && destFile.equals((origFile+1).toChar) && destRank.equals(origRank - 1) && board.getSquare(to).mannedByWhite()
      ||color.equals('b') && destFile.equals((origFile-1).toChar) && destRank.equals(origRank - 1) && board.getSquare(to).mannedByWhite()) {
      true
    } else false
  }


  override def toString: String = {
    color match {
      case 'w' => "\u265F"
      case 'b' => "\u2659"
    }
  }
}
