package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers{
  "A Knight" when {
    "set as white and black Knight to b1 and b8" should {
      val whiteKnight = Knight("c3", 'w')
      val blackKnight = Knight("c6", 'b')
      "have a String representation" in {
        whiteKnight.toString should be ("\u265E")
        blackKnight.toString should be ("\u2658")
      }
      "be set on a board" should {
        val board = new Board().setPiece(whiteKnight).setPiece(blackKnight)
        "white Knight moves from square c3 to e4 and change turn" in {
          board.moveWhite("c3", "e4").getSquare("e4").toString should be (whiteKnight.toString)
        }
        "white Knight moves from square c3 to d5" in {
          board.moveWhite("c3", "d5").getSquare("d5").toString should be (whiteKnight.toString)
        }
        "black Knight moves from square C6 to b4" in {
          board.moveBlack("c6", "b4").getSquare("b4").toString should be (blackKnight.toString)
        }
        "black Knight moves from square C6 to a5" in {
          board.moveBlack("c6", "a5").getSquare("a5").toString should be (blackKnight.toString)
        }
        "do nothing, if illegal move" in {
          board.moveWhite("c3", "h6").getSquare("c3").toString should be (whiteKnight.toString)
        }
        "when white turns end change color to 'b'" in {
          board.moveWhite("c3", "d5").whichTurn should be ('b')
          board.moveBlack("c6", "b4").whichTurn should be ('w')
        }
      }
    }
  }
}
