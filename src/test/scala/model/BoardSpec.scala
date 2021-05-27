package model

import model.pieces.{Pawn, Piece}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class BoardSpec extends AnyWordSpec with Matchers {
  "A Board is the field of Chess. A Board" when {
    "to be constructed" should {
      val board = new Board()
      "be created with the length 8 " in {
        board.len should be (8)
      }
      "have a String representation" in {
        board.toString should be(
          """    a b c d e f g h

            |8   - - - - - - - -   8
            |7   - - - - - - - -   7
            |6   - - - - - - - -   6
            |5   - - - - - - - -   5
            |4   - - - - - - - -   4
            |3   - - - - - - - -   3
            |2   - - - - - - - -   2
            |1   - - - - - - - -   1
            |
            |    a b c d e f g h
            |
            |""".stripMargin)
      }
      "set white Pawn to a1 " in {
        board.setPiece(Pawn("a1", 'w')).getSquare("a1") should be(board.getSquare("a1"))
      }
      "set start position " in {
        board.startPosition().getSquare("a2") should be(Square("a2", Some(Pawn("a2", 'w'))))
      }
      "remove Pawn at a2" in {
        board.startPosition().removePiece("a2").getSquare("a2") should be (Square("a2", None))
      }
      "move white pawn from a2 to a3" in {
        board.startPosition().move("a2", "a3").getSquare("a3") should be (Square("a3", Some(Pawn("a3", 'w'))))
      }
      "move black pawn from a7 to a6 after set turn to black" in {
        board.startPosition().move("a7", "a6").getSquare("a6") should be (Square("a6", Some(Pawn("a6", 'b'))))
      }
      "not move white pawn from a3, if there is no white pawn on a3" in {
        board.startPosition().move("a3", "a4").getSquare("a4") should be (Square("a4", None))
      }
      "not move black pawn from a6, if there is no black pawn on a6" in {
        board.startPosition().move("a6", "a5").getSquare("a5") should be (Square("a5", None))
      }
    }
  }
}
