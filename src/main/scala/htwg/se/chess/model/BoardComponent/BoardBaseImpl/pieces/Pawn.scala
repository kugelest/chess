package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece}

case class Pawn(getPos: String, getColor: Char, kind: String = "pawn") extends Piece(getPos, getColor, kind) {

  def whiteMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    (getColor.equals('w'), destFile.compareTo(origFile), destRank - origRank, board.getSquare(to).get) match {
      case (true, 0, 1, dest) if dest.isFree => true
      case (true, 0, 2, dest) if dest.isFree && origRank.equals(2) => true
      case (true, -1, 1, dest) if dest.mannedByBlack => true
      case (true, 1, 1, dest) if dest.mannedByBlack => true
      case _ => false
    }
  }

  def blackMovePossible(to: String, board: Board): Boolean = {
    val (destFile, destRank, origFile, origRank) = convertMove(to)
    (getColor.equals('b'), destFile.compareTo(origFile), destRank - origRank, board.getSquare(to).get) match {
      case (true, 0, -1, dest) if dest.isFree => true
      case (true, 0, -2, dest) if dest.isFree && origRank.equals(7) => true
      case (true, -1, -1, dest) if dest.mannedByWhite => true
      case (true, 1, -1, dest) if dest.mannedByWhite => true
      case _ => false
    }
  }


  override def toString: String = {
    getColor match {
      case 'w' => "♙"
      case 'b' => "♟"
    }
  }
}

object Pawn {

  import play.api.libs.json._

  implicit val pieceWrites: Writes[Pawn] = Json.writes[Pawn]
  implicit val pieceReads: Reads[Pawn] = Json.reads[Pawn]

}
