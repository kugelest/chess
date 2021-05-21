package controller

import controller.states.State
import model.Board
import util.Memento

class BoardMemento(state: State, board: Board) extends Memento {

  override def getState: State = {
    state
  }
  override def getBoard: Board = {
    board
  }
}
