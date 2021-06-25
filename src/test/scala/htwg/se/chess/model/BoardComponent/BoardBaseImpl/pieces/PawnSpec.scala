package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PawnSpec extends AnyWordSpec with Matchers {
  "A Pawn" when {
    "set as white and black Pawn to b2 and b7" should {
      val whitePawn = Pawn("b2", 'w')
      val blackPawn = Pawn("b7", 'b')
      val board = new Board().setPiece(whitePawn).setPiece(blackPawn)

      "have a String representation" in {
        whitePawn.toString should be ("♙")
        blackPawn.toString should be ("♟")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("b2", "b3") should be (true)
        board.whiteMovePossible("b2", "b5") should be (false)
      }
      "check if black move is possible" in {
        board.blackMovePossible("b7", "b6") should be (true)
        board.blackMovePossible("b7", "b4") should be (false)
      }
    }
    "set as white and black Pawn to b2 and c3" should {
      val whitePawn = Pawn("b2", 'w')
      val blackPawn = Pawn("c3", 'b')
      val board = new Board().setPiece(whitePawn).setPiece(blackPawn)
      "check if take is possible" in {
        board.whiteMovePossible("b2", "c3") should be(true)
        board.blackMovePossible("c3", "b2") should be(true)
      }
    }
  }
}