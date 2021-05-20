package controller

import model.pieces.Piece
import util.Memento

class BoardMemento(board: Vector[Piece]) extends Memento {
  private val chessboard =  board

  override def getPieces: Vector[Piece] = {
    chessboard
  }
}
