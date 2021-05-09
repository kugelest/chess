package model

case class Knight(pos: String, color: Char) extends Piece {

  def move(to: String, board: Board): Board = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = pos.charAt(0)
    val origRank = pos.charAt(1).asDigit

    color match {
      case 'w' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByBlack()){ // Check if square is free,manned by black or white
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){ // Check if knight is moving 1 square left or right
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){ // Check if knight is moving 2 squares up or down
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color) // Change players turn
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){ // Check if knight is moving 2 squares left or right
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){ // Check if knight is moving 1 square up or down
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color) // Change players turn
          } else board.setTurn(color) // Change players turn
        } else board.setTurn(color) // Change players turn
      case 'b' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByWhite()){ // Check if square is free,manned by black or white
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){ // Check if knight is moving 1 square left or right
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){ // Check if knight is moving 2 squares up or down
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color) // Change players turn
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){ // Check if knight is moving 2 squares left or right
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){ // Check if knight is moving 1 square up or down
              board.removePiece(pos).setPiece(Knight(to, color))
            } else board.setTurn(color) // Change players turn
          } else board.setTurn(color) // Change players turn
        } else board.setTurn(color) // Change players turn
    }
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265E"
      case 'b' => "\u2658"
    }
  }
}
