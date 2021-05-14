package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PawnSpec extends AnyWordSpec with Matchers {
  "A Pawn" when {
    "set as white and black Pawn to b2 and b7" should {
      val whitePawn = Pawn("b2", 'w')
      val blackPawn = Pawn("b7", 'b')
      val board = new Board().setPiece(whitePawn).setPiece(blackPawn)

      "have a String representation" in {
        whitePawn.toString should be ("\u265F")
        blackPawn.toString should be ("\u2659")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("b2", "b3") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("b7", "b6") should be (true)
      }
    }
  }
}