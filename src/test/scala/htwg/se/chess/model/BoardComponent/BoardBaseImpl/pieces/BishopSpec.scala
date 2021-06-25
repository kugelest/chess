package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BishopSpec extends AnyWordSpec with Matchers {
  "A Bishop" when {
    "set as white and black Bishop to c1 and c7" should {
      val whiteBishop = Bishop("c1", 'w')
      val blackBishop = Bishop("c7", 'b')
      val board = new Board().setPiece(whiteBishop).setPiece(blackBishop)

      "have a String representation" in {
        whiteBishop.toString should be ("♗")
        blackBishop.toString should be ("♝")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("c1", "b2") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("c7", "b6") should be (true)
      }
      "check if white move is not possible" in {
        board.whiteMovePossible("c1", "b3") should be (false)
      }
      "check if black move is not possible" in {
        board.blackMovePossible("c7", "b5") should be (false)
      }
    }
  }
}
