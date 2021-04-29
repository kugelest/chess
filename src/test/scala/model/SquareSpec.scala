package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class SquareSpec extends AnyWordSpec with Matchers {
  "A Square" when {
    "empty " should {
      val square = Square("a1", None)
      "have a String representation" in {
        square.toString should be("-")
      }
    }
  }
}