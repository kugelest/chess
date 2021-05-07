package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers{
  "A Knight" when {
    "set as white and black Knight to b1 and b8" should {
      val whiteKnight = Knight("b1", 'w')
      val blackKnight = Knight("b8", 'b')
      "have a String representation" in {
        whiteKnight.toString should be ("\u265E")
        blackKnight.toString should be ("\u2658")
      }
      "be set on a board" should {
        val board = new Board().setPiece(whiteKnight).setPiece(blackKnight)
        "white Knight moves from square c3 to e4" in {
          board.moveWhite("c3", "e4").getSquare("e4").toString should be (whiteKnight.toString)
        }
        "black Knight moves to square C3" in {
          board.moveBlack("b8", "c3").getSquare("b8").toString should be (blackKnight.toString)
        }
        "do nothing, if illegal move" in {
          board.moveWhite("b1", "h6").getSquare("b1").toString should be (whiteKnight.toString)
        }
      }
    }
  }
}
