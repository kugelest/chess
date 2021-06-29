package htwg.se.chess.model.BoardComponent.BoardBaseImpl.pieces

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RookSpec extends AnyWordSpec with Matchers {
  "A Rook" when {
    "set as white and black Rook to a1 and a8" should {
      val whiteRook = Rook("a1", 'w')
      val blackRook = Rook("a8", 'b')
      val board = new Board().setPiece(whiteRook).setPiece(blackRook)

      "have a String representation" in {
        whiteRook.toString should be ("♖")
        blackRook.toString should be ("♜")
      }
      "check if white move is possible" in {
        board.whiteMovePossible("a1", "a6") should be (true)
      }
      "check if black move is possible" in {
        board.blackMovePossible("a8", "a6") should be (true)
      }
    }
  }
}