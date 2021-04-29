package model

trait Piece {
  def pos: String
  def color: Char

  def move(to: String, board: Board): Board
  def getFile: Char = pos.head
  def getRank: Int = pos.tail.toInt
}
