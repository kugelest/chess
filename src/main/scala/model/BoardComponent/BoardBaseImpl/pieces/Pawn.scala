package model.BoardComponent.BoardBaseImpl.pieces

import com.google.inject.Inject
import model.BoardComponent.BoardBaseImpl.{Board, Piece}
import model.BoardComponent.PieceInterface

case class Pawn (getPos: String, getColor: Char, kind: String = "pawn") extends Piece(getPos, getColor, kind) {

  def whiteMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    (getColor.equals('w'), destFile.compareTo(origFile), destRank-origRank, board.getSquare(to).get) match {
      case (true, 0, 1, dest) if dest.isFree => true
      case (true, 0, 2, dest) if dest.isFree && origRank.equals(2) => true
      case (true, -1, 1, dest) if dest.mannedByBlack => true
      case (true, 1, 1, dest) if dest.mannedByBlack => true
      case _ => false
    }
  }

  def blackMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    (getColor.equals('b'), destFile.compareTo(origFile), destRank-origRank, board.getSquare(to).get) match {
      case (true, 0, -1, dest) if dest.isFree => true
      case (true, 0, -2, dest) if dest.isFree && origRank.equals(7) => true
      case (true, -1, -1, dest) if dest.mannedByWhite => true
      case (true, 1, -1, dest) if dest.mannedByWhite => true
      case _ => false
    }
  }


  override def toString: String = {
    getColor match {
      case 'w' => "\u265F"
      case 'b' => "\u2659"
    }
  }
}
