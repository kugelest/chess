package model

import model.BoardComponent.BoardBaseImpl.Square
import model.BoardComponent.BoardBaseImpl.pieces.Pawn
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class SquareSpec extends AnyWordSpec with Matchers {
  "A Square" when {
    "empty " should {
      val square = Square("a1", None)
      "have a String representation and be free" in {
        square.toString should be("-")
        square.isFree should be(true)
      }
    }
    "mannedByWhite " should {
      val square = Square("a2", Some(Pawn("a2", 'w')))
        "have a white Pawn in Square A2" in {
        }
      }
    "mannedByBlack " should {
      val square = Square("a7", Some(Pawn("a7", 'b')))
        "have a black Pawn in Square A7" in {
        }
      }
    "created with position values" should{
      val square = Square("a2", Some(Pawn("a2", 'w')))
        "a letter (a-h) and a number (1-8)" in {
          square.getFile should be('a')
          square.getRank should be(2)
        }
      }
    }
}