package model.pieces

import model.Board

trait Piece {
  def pos: String
  def color: Char
  def kind: String

  def whiteMovePossible(to: String, board: Board): Boolean
  def blackMovePossible(to: String, board: Board): Boolean
  def getFile: Char = pos.head
  def getRank: Int = pos.tail.toInt

  def convertMove(to: String): (Char, Int, Char, Int) = {
    val destFile = to.charAt(0)
    val destRank = to.charAt(1).asDigit
    val origFile = pos.charAt(0)
    val origRank = pos.charAt(1).asDigit
    (destFile, destRank, origFile, origRank)
  }
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

