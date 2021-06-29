package htwg.se.chess.model.BoardComponent.BoardBaseImpl

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.Predef.Map

class PieceSpec extends AnyWordSpec with Matchers {
  "A Piece" when {
    "set as white and black Queen to d1 and d8" should {
      val whiteQueen = Piece("queen", "d4", 'w')
      val blackPawn1 = Piece("pawn", "d8", 'b')
      val blackPawn2 = Piece("pawn", "d1", 'b')
      val blackPawn3 = Piece("pawn", "a4", 'b')
      val blackPawn4 = Piece("pawn", "h4", 'b')
      val blackPawn5 = Piece("pawn", "a7", 'b')
      val blackPawn6 = Piece("pawn", "h8", 'b')
      val blackPawn7 = Piece("pawn", "a1", 'b')
      val blackPawn8 = Piece("pawn", "g1", 'b')
      val board = new Board().setPiece(whiteQueen).setPiece(blackPawn1)


      "have eyes up" in {
        whiteQueen.eyesUp(board.getSquare(whiteQueen.getPos).get, board) should be
        (Square("d5", None), Square("d6", None), Square("d7", None), Square("d8", Some(blackPawn1)))
      }

      "have eyes down" in {
        whiteQueen.eyesDown(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("d4", None), Square("d3", None), Square("d2", None), Square("d1", Some(blackPawn2)))
      }

      "have eyes left" in {
        whiteQueen.eyesLeft(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("c4", None), Square("b4", None), Square("a4", Some(blackPawn3)))
      }

      "have eyes right" in {
        whiteQueen.eyesRight(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("e4", None), Square("f4", None), Square("g4", None), Square("h4", Some(blackPawn4)))
      }

      "have eyes up left" in {
        whiteQueen.eyesUpLeft(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("c5", None), Square("b6", None), Square("a7", Some(blackPawn5)))
      }

      "have eyes up right" in {
        whiteQueen.eyesUpRight(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("e5", None), Square("f6", None), Square("g7", None), Square("h8", Some(blackPawn6)))
      }

      "have eyes down left" in {
        whiteQueen.eyesDownLeft(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("c3", None), Square("b2", None), Square("a1", Some(blackPawn7)))
      }

      "have eyes down right" in {
        whiteQueen.eyesDownRight(board.getSquare(whiteQueen.getPos).get, board) should be
        List(Square("e3", None), Square("f2", None), Square("g1", Some(blackPawn8)))
      }
    }
  }
}
