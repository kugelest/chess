package model

case class Knight(pos: String, color: Char, kind: String = "knight") extends Piece {

  override def whiteMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    color match {
      case 'w' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByBlack()){ // Check if square is free,manned by black or white
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){ // Check if knight is moving 1 square left or right
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){ // Check if knight is moving 2 squares up or down
              true
            } else false // Change players turn
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){ // Check if knight is moving 2 squares left or right
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){ // Check if knight is moving 1 square up or down
              true
            } else false // Change players turn
          } else false // Change players turn
        } else false // Change players turn
      case _ => false
    }
  }

  override def blackMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    color match {
      case 'b' =>
        if(board.getSquare(to).isFree || board.getSquare(to).mannedByWhite()){ // Check if square is free,manned by black or white
          if(destFile.equals((origFile + 1).toChar) || destFile.equals((origFile - 1).toChar)){ // Check if knight is moving 1 square left or right
            if(destRank.equals(origRank + 2) || destRank.equals(origRank - 2)){ // Check if knight is moving 2 squares up or down
              true
            } else false // Change players turn
          } else if (destFile.equals((origFile + 2).toChar) || destFile.equals((origFile - 2).toChar)){ // Check if knight is moving 2 squares left or right
            if(destRank.equals(origRank + 1) || destRank.equals(origRank - 1)){ // Check if knight is moving 1 square up or down
              true
            } else false // Change players turn
          } else false // Change players turn
        } else false // Change players turn
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
