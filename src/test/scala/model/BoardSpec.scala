package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class BoardSpec extends AnyWordSpec with Matchers {
  "A Board" when {
    "len is not set " should {
      val board = new Board()
      "have a String representation" in {
        board.toString should be(
          """    A B C D E F G H

            |8   - - - - - - - -   8
            |7   - - - - - - - -   7
            |6   - - - - - - - -   6
            |5   - - - - - - - -   5
            |4   - - - - - - - -   4
            |3   - - - - - - - -   3
            |2   - - - - - - - -   2
            |1   - - - - - - - -   1
            |
            |    A B C D E F G H
            |
            |""".stripMargin)
      }
    }
    "set Pawn to A1 " should {
      val board = new Board().setPiece('A', 1, 'P')
      "should contain Square with value 'P'" in {
        board.squares(7) should contain(Square('A', 1, 'P'))
      }
    }
    "set start position " should {
      val board = new Board().startPosition()
      "should contain Square with value 'P'" in {
        board.squares(6) should contain(Square('A', 2, 'P'))
      }
    }
  }
}
