package model

case class Pawn(pos: String, color: Char) extends Piece {

//  def move(to: String, board: Board): Board = {
//    board.removePiece(pos).setPiece(to, Pawn(to, color))
//  }

  def move(to: String, board: Board): Board = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = pos.charAt(0)
    val origRank = pos.charAt(1).asDigit

    if (color.equals('w') && destFile.equals(origFile) && destRank.equals(origRank + 1) && board.getSquare(to).isFree()
      ||color.equals('w') && destFile.equals((origFile+1).toChar) && destRank.equals(origRank + 1) && board.getSquare(to).mannedByBlack()
      ||color.equals('w') && destFile.equals((origFile-1).toChar) && destRank.equals(origRank + 1) && board.getSquare(to).mannedByBlack()
      ||color.equals('b') && destFile.equals(origFile) && destRank.equals(origRank - 1) && board.getSquare(to).isFree()
      ||color.equals('b') && destFile.equals((origFile+1).toChar) && destRank.equals(origRank - 1) && board.getSquare(to).mannedByWhite()
      ||color.equals('b') && destFile.equals((origFile-1).toChar) && destRank.equals(origRank - 1) && board.getSquare(to).mannedByWhite()) {
      board.removePiece(pos).setPiece(Pawn(to, color))
    } else board
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265F"
      case 'b' => "\u2659"
    }
  }
}
