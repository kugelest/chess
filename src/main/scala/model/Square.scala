package model

case class Square(file: Char, rank: Int, value: Option[Piece]) {
  override def toString: String = {
    value match {
      case Some(value) => value.toString
      case None => "-"
    }
  }
}