package model

import model.BoardComponent.BoardBaseImpl.Board
import model.BoardComponent.BoardBaseImpl.pieces.Queen
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class QueenSpec extends AnyWordSpec with Matchers {
  "A Queen" when {
    "set as white and black Queen to d1 and d8" should {
      val whiteQueen = Queen("d1", 'w')
      val blackQueen = Queen("d8", 'b')
      val board = new Board().setPiece(whiteQueen).setPiece(blackQueen)

      "have a String representation" in {
        whiteQueen.toString should be ("\u265B")
        blackQueen.toString should be ("\u2655")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("d1", "e2") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("d8", "e7") should be (true)
      }
    }
  }
}