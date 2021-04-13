package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class SquareSpec extends AnyWordSpec with Matchers {
  "A Square" when {
    "new " should {
      val square = Square('A', 1)
      "have a String representation" in {
        square.toString should be("-")
      }
    }
  }
}