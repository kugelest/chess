package controller

import controller.states.State
import model.BoardComponent.BoardBaseImpl.Board
import model.BoardComponent.BoardInterface
import util.Memento

class BoardMemento(state: State, board: BoardInterface) extends Memento {

  override def getState: State = {
    state
  }
  override def getBoard: BoardInterface = {
    board
  }
}
