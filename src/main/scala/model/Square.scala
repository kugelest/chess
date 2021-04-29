package model

case class Square(pos: String, piece: Option[Piece]) {
  //def getPiece: Option[Piece] = piece
  def getFile: Char = pos.head
  def getRank: Int = pos.tail.toInt
  def isFree: Boolean = piece.isDefined
  def mannedByWhite(): Boolean = piece.get.color.equals('w')
  def mannedByBlack(): Boolean = piece.get.color.equals('b')
  override def toString: String = piece.getOrElse("-").toString
}