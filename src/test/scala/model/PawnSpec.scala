package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PawnSpec extends AnyWordSpec with Matchers {
  "A Pawn" when {
    "set as white and black Pawn to b3 and c4" should {
      val whitePawn = Pawn("b3", 'w')
      val blackPawn = Pawn("c4", 'b')
<<<<<<< HEAD
      "have a String representaion" in {
=======
      "have a String representation" in {
>>>>>>> factory
        whitePawn.toString should be ("\u265F")
        blackPawn.toString should be ("\u2659")
      }
      "be set on a board" should {
        val board = new Board().setPiece(whitePawn).setPiece(blackPawn)
        "black Pawn take white Pawn" in {
          board.moveBlack("c4", "b3").getSquare("b3").toString should be (blackPawn.toString)
        }
        "do nothing, if illegal move" in {
          board.moveWhite("b3", "h6").getSquare("b3").toString should be (whitePawn.toString)
        }
      }
    }

  }
}