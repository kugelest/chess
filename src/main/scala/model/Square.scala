package model

case class Square(file: Char, rank: Int, piece: Option[Piece]) {

  def getPiece: Option[Piece] = {
    piece
  }

  def isFree: Boolean = {
    piece match {
      case Some(piece) => false
      case _ => true
    }
  }

  def mannedByWhite(): Boolean = {
    piece match {
      case Some(piece) => piece.color.equals('w')
      case _ => false
    }
  }

  def mannedByBlack(): Boolean = {
    piece match {
      case Some(piece) => piece.color.equals('b')
      case _ => false
    }
  }

  override def toString: String = {
    piece match {
      case Some(value) => value.toString
      case None => "-"
    }
  }
}