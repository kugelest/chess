package model

import model.pieces.Piece
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers{
  "A Knight" when {
    "set as white and black Knight" should {
      val whiteKnight = Piece("knight", "c3", 'w')
      val blackKnight = Piece("knight", "c6", 'b')
      val whitePawn = Piece("pawn", "d4", 'w')
      val blackPawn = Piece("pawn", "b5", 'b')
      val board = new Board().setPiece(whiteKnight).setPiece(blackKnight).setPiece(whitePawn).setPiece(blackPawn)
      "have a String representation" in {
        whiteKnight.toString should be ("\u265E")
        blackKnight.toString should be ("\u2658")
      }
      "be able to move 2 Squares up and 1 right" in {
        board.whiteMovePossible("c3", "d5") should be (true)
        board.blackMovePossible("c6", "b4") should be (true)
      }
      "be able to move 1 Squares up and 2 right" in {
        board.whiteMovePossible("c3", "e4") should be (true)
        board.blackMovePossible("c6", "a5") should be (true)
      }
      "not be able to move" in {
        board.whiteMovePossible("c3", "e5") should be (false)
        board.blackMovePossible("c6", "a4") should be (false)
        board.whiteMovePossible("c3", "d6") should be (false)
        board.blackMovePossible("c6", "b3") should be (false)
        board.whiteMovePossible("c3", "d4") should be (false)
        board.blackMovePossible("c6", "b5") should be (false)
        board.whiteMovePossible("c3", "f4") should be (false)
        board.blackMovePossible("c6", "f5") should be (false)
      }
    }
  }
}
