package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QueenSpec extends AnyWordSpec with Matchers {
  "A Queen" when {
    "set as white and black Queen to d1 and d8" should {
      val whiteQueen = Queen("d1", 'w')
      val blackQueen = Queen("d8", 'b')
      val board = new Board().setPiece(whiteQueen).setPiece(blackQueen)

      "have a String representation" in {
        whiteQueen.toString should be ("♕")
        blackQueen.toString should be ("♛")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("d1", "e2") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("d8", "e7") should be (true)
      }
      "check if white move is not possible" in {
        board.whiteMovePossible("d1", "e3") should be (false)
      }
      "check if black move is not possible" in {
        board.blackMovePossible("d8", "e6") should be (false)
      }
    }
  }
}