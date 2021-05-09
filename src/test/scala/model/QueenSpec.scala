package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QueenSpec extends AnyWordSpec with Matchers{
  "A Queen" when {
    "set as white and black Queen to d1 and d8" should {
      val whiteQueen = Queen("d1", 'w')
      val blackQueen = Queen("d8", 'b')
      "have a String representation" in {
        whiteQueen.toString should be("\u265B")
        blackQueen.toString should be("\u2655")
      }
      "be set to board" should {
        val board = new Board().setPiece(whiteQueen)
        "and do an illegal moved from d1 to d2" in {
          board.moveWhite("d1", "d2").getSquare("d2").toString should be (whiteQueen.toString)
        }
      }
    }
  }
}
