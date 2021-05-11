package model

case class Knight(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = pos.charAt(0)
    val origRank = pos.charAt(1).asDigit

    color match {
      case 'w' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByBlack()){
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color)
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color)
          } else board.setTurn(color)
        } else board.setTurn(color)
      case 'b' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByWhite()){
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color)
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color)
          } else board.setTurn(color)
        } else board.setTurn(color)
    }
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265E"
      case 'b' => "\u2658"
    }
  }
}
