package model

case class Square(file: Char, rank: Int, value: Char = '-') {
  override def toString: String = {
    value.toString
  }
}