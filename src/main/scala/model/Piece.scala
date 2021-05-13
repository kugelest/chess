package model

trait Piece {
  def pos: String
  def color: Char
  def kind: String

  def move(to: String, board: Board): Board = board.removePiece(pos).setPiece(Piece(kind, to, color))
  def getFile: Char = pos.head
  def getRank: Int = pos.tail.toInt
}

object Piece {
 def apply(kind: String, pos: String, color: Char): Piece = kind match {
   case "king" => King(pos, color)
   case "queen" => Queen(pos, color)
   case "rook" => Rook(pos, color)
   case "knight" => Knight(pos, color)
   case "bishop" => Bishop(pos, color)
   case "pawn" => Pawn(pos, color)
 }
}

