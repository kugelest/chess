package htwg.se.chess.controller

import htwg.se.chess.controller.states.State
import htwg.se.chess.model.BoardComponent.BoardInterface
import htwg.se.chess.util.Memento

class BoardMemento(state: State, board: BoardInterface) extends Memento {

  override def getState: State = {
    state
  }

  override def getBoard: BoardInterface = {
    board
  }
}
