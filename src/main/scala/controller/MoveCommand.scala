package controller

import controller.states.State
import model.pieces.Piece
import util.Command

class MoveCommand(from: String, to: String, var state: State) extends Command {
  var memento = new BoardMemento(state)

  override def doStep(): Unit = {
    //memento = new BoardMemento()
    state.move(from, to)
  }
  override def undoStep(): Unit = {
//    controller.createEmptyBoard()
    state = memento.getState
//    controller.board.startPosition(memento.getController)
    //controller.board = controller.board.move(from, to)
  }
  override def redoStep(): Unit = {
    state.move(from, to)
  }
}
