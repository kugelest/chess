package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RookSpec extends AnyWordSpec with Matchers{
  "A Rook" when {
    "set as white and black Rook to a1 and a8" should {
      val whiteRook = Rook("a1", 'w')
      val blackRook = Rook("a8", 'b')
      "have a String representation" in {
        whiteRook.toString should be("\u265C")
        blackRook.toString should be("\u2656")
      }
    }
  }
}
