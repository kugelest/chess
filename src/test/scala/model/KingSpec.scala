package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class KingSpec extends AnyWordSpec with Matchers {
  "A King" when {
    "set as white and black King to e1 and e8" should {
      val whiteKing = King("e1", 'w')
      val blackKing = King("e8", 'b')
      val board = new Board().setPiece(whiteKing).setPiece(blackKing)
      
      "have a String representation" in {
        whiteKing.toString should be ("\u265A")
        blackKing.toString should be ("\u2654")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("e1", "e2") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("e8", "e7") should be (true)
      }
    }
  }
}