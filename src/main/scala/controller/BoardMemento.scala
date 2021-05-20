package controller

import controller.states.State
import model.Board
import model.pieces.Piece
import util.Memento

class BoardMemento(state: State, board: Board) extends Memento {
//  private val chessboard =  board

  override def getState: State = {
    state
  }
  override def getBoard: Board = {
    board
  }
}
