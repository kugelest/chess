package htwg.se.chess.model.BoardComponent.BoardBaseImpl

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BoardSpec extends AnyWordSpec with Matchers {
  "A Board is the field of Chess. A Board" when {
    "to be constructed" should {
      val board = new Board()
      "be created with the length 8 " in {
        board.len should be (8)
        board.toString
      }
    }
  }
}
