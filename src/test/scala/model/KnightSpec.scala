package model

import model.pieces.Piece
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers{
  "A Knight" when {
    "set as white and black Knight" should {
      val whiteKnight = Piece("knight", "c3", 'w')
      val blackKnight = Piece("knight", "c6", 'b')
      val whitePawn = Piece("pawn", "d4", 'w')
      val blackPawn = Piece("pawn", "d5", 'b')
      val board = new Board().setPiece(whiteKnight).setPiece(blackKnight).setPiece(whitePawn).setPiece(blackPawn)
      "have a String representation" in {
        whiteKnight.toString should be ("\u265E")
        blackKnight.toString should be ("\u2658")
      }
      "white be able to move 2 Square up and 1 right" in {
        board.whiteMovePossible("c3", "d5") should be (true)
        board.move("c3", "d5").getSquare("d5").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square up and 1 right manned by black" in {
        board.whiteMovePossible("c3", "d5") should be (true)
        board.getSquare("d5").mannedByBlack() should be (true)
        board.move("c3", "d5").getSquare("d5").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square up and 1 left" in {
        board.whiteMovePossible("c3", "b5") should be (true)
        board.move("c3", "b5").getSquare("b5").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square down and 1 right" in {
        board.whiteMovePossible("c3", "d1") should be (true)
        board.move("c3", "d1").getSquare("d1").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square down and 1 left" in {
        board.whiteMovePossible("c3", "b1") should be (true)
        board.move("c3", "b1").getSquare("b1").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square right and 1 up" in {
        board.whiteMovePossible("c3", "e4") should be (true)
        board.move("c3", "e4").getSquare("e4").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square right and 1 down" in {
        board.whiteMovePossible("c3", "e2") should be (true)
        board.move("c3", "e2").getSquare("e2").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square left and 1 up" in {
        board.whiteMovePossible("c3", "a4") should be (true)
        board.move("c3", "a4").getSquare("a4").toString should be (whiteKnight.toString)
      }
      "white be able to move 2 Square left and 1 down" in {
        board.whiteMovePossible("c3", "a2") should be (true)
        board.move("c3", "a2").getSquare("a2").toString should be (whiteKnight.toString)
      }
      "white not be able to move 2 Square up and 2 left" in {
        board.whiteMovePossible("c3", "a5") should be (false)
        board.move("c3", "a5").getSquare("a5").toString should be (whiteKnight.toString)
      }
      "white not be able to move 2 Square up and 2 right" in {
        board.whiteMovePossible("c3", "e5") should be (false)
        board.move("c3", "e5").getSquare("e5").toString should be (whiteKnight.toString)
      }
      "white not be able to move 1 Square up and 1 left" in {
        board.whiteMovePossible("c3", "b4") should be (false)
        board.move("c3", "b4").getSquare("b4").toString should be (whiteKnight.toString)
      }
      "white not be able to move 1 Square up and 1 right" in {
        board.whiteMovePossible("c3", "d4") should be (false)
        board.move("c3", "d4").getSquare("d4").toString should be (whiteKnight.toString)
      }
      "white not be able to move 2 Square down and 2 left" in {
        board.whiteMovePossible("c3", "a1") should be (false)
        board.move("c3", "a1").getSquare("a1").toString should be (whiteKnight.toString)
      }
      "white not be able to move 2 Square down and 2 right" in {
        board.whiteMovePossible("c3", "e1") should be (false)
        board.move("c3", "e1").getSquare("e1").toString should be (whiteKnight.toString)
      }
      "white not be able to move 1 Square down and 1 left" in {
        board.whiteMovePossible("c3", "b2") should be (false)
        board.move("c3", "b2").getSquare("b2").toString should be (whiteKnight.toString)
      }
      "white not be able to move 1 Square down and 3 right" in {
        board.whiteMovePossible("c3", "f2") should be (false)
        board.move("c3", "f2").getSquare("f2").toString should be (whiteKnight.toString)
      }
      "black be able to move 2 Square down and 1 right" in {
        board.blackMovePossible("c6", "d4") should be (true)
        board.move("c6", "d4").getSquare("d4").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square down and 1 right manned by white" in {
        board.blackMovePossible("c6", "d4") should be (true)
        board.getSquare("d4").mannedByWhite() should be (true)
        board.move("c6", "d4").getSquare("d4").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square down and 1 left" in {
        board.blackMovePossible("c6", "b4") should be (true)
        board.move("c6", "b4").getSquare("b4").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square up and 1 right" in {
        board.blackMovePossible("c6", "d8") should be (true)
        board.move("c6", "d8").getSquare("d8").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square up and 1 left" in {
        board.blackMovePossible("c6", "b8") should be (true)
        board.move("c6", "b8").getSquare("b8").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square right and 1 up" in {
        board.blackMovePossible("c6", "e7") should be (true)
        board.move("c6", "e7").getSquare("e7").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square right and 1 down" in {
        board.blackMovePossible("c6", "e5") should be (true)
        board.move("c6", "e5").getSquare("e5").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square left and 1 up" in {
        board.blackMovePossible("c6", "a7") should be (true)
        board.move("c6", "a7").getSquare("a7").toString should be (blackKnight.toString)
      }
      "black be able to move 2 Square left and 1 down" in {
        board.blackMovePossible("c6", "a5") should be (true)
        board.move("c6", "a5").getSquare("a5").toString should be (blackKnight.toString)
      }
      "black not be able to move 2 Square down and 2 right" in {
        board.blackMovePossible("c6", "e4") should be (false)
        board.move("c6", "e4").getSquare("e4").toString should be (blackKnight.toString)
      }
      "black not be able to move 2 Square down and 2 left" in {
        board.blackMovePossible("c6", "a4") should be (false)
        board.move("c6", "a4").getSquare("a4").toString should be (blackKnight.toString)
      }
      "black not be able to move 2 Square up and 2 right" in {
        board.blackMovePossible("c6", "e8") should be (false)
        board.move("c6", "e8").getSquare("e8").toString should be (blackKnight.toString)
      }
      "black not be able to move 2 Square up and 2 left" in {
        board.blackMovePossible("c6", "a8") should be (false)
        board.move("c6", "a8").getSquare("a8").toString should be (blackKnight.toString)
      }
      "black not be able to move 1 Square down and 1 right" in {
        board.blackMovePossible("c6", "d5") should be (false)
        board.move("c6", "d5").getSquare("d5").toString should be (blackKnight.toString)
      }
      "black not be able to move 1 Square down and 1 left" in {
        board.blackMovePossible("c6", "b5") should be (false)
        board.move("c6", "b5").getSquare("b5").toString should be (blackKnight.toString)
      }
      "black not be able to move 1 Square up and 1 right" in {
        board.blackMovePossible("c6", "d7") should be (false)
        board.move("c6", "d7").getSquare("d7").toString should be (blackKnight.toString)
      }
      "black not be able to move 1 Square up and 1 left" in {
        board.blackMovePossible("c6", "b7") should be (false)
        board.move("c6", "b7").getSquare("b7").toString should be (blackKnight.toString)
      }
      "black not be able to move 1 Square up and 3 right" in {
        board.blackMovePossible("c6", "f7") should be (false)
        board.move("c6", "f7").getSquare("f7").toString should be (blackKnight.toString)
      }
    }
  }
}
