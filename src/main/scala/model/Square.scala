package model

case class Square(pos: String, piece: Option[Piece]) {
  def getFile: Char = pos.head
  def getRank: Int = pos.tail.toInt
  def isFree: Boolean = piece.isEmpty
  def mannedByWhite(): Boolean = if (piece.isDefined) piece.get.color.equals('w') else false
  def mannedByBlack(): Boolean = if (piece.isDefined) piece.get.color.equals('b') else false
  override def toString: String = piece.getOrElse("-").toString
}