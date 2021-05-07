package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KingSpec extends AnyWordSpec with Matchers{
  "A King" when {
    "set as white and black King to E1 and E8" should {
      val whiteKing = King("e1", 'w')
      val blackKing = King("e8", 'b')
      "have a String representation" in {
        whiteKing.toString should be("\u265A")
        blackKing.toString should be("\u2654")
      }
    }
  }
}
