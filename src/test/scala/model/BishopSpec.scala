package model

import model.pieces.Bishop
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class BishopSpec extends AnyWordSpec with Matchers {
  "A Bishop" when {
    "set as white and black Bishop to c1 and c7" should {
      val whiteBishop = Bishop("c1", 'w')
      val blackBishop = Bishop("c7", 'b')
      val board = new Board().setPiece(whiteBishop).setPiece(blackBishop)

      "have a String representation" in {
        whiteBishop.toString should be ("\u265D")
        blackBishop.toString should be ("\u2657")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("c1", "b2") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("c7", "b6") should be (true)
      }
    }
  }
}