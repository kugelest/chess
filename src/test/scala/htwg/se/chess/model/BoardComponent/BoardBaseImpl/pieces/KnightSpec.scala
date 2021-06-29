package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers{
  "A Knight" when {
    "set as white and black Knight" should {
      val whiteKnight = Knight("c3", 'w')
      val blackKnight = Knight("c6", 'b')
      val whitePawn = Knight("d4", 'w')
      val blackPawn = Knight("b5", 'b')
      val board = new Board().setPiece(whiteKnight).setPiece(blackKnight).setPiece(whitePawn).setPiece(blackPawn)
      "have a String representation" in {
        whiteKnight.toString should be ("♘")
        blackKnight.toString should be ("♞")
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