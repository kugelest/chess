package controller

import model.Board
import model.pieces.Piece
import util.Memento

class BoardMemento(board: Board) extends Memento {
//  private val chessboard =  board

  override def getBoard: Board = {
    board
  }
}
