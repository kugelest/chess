package controller

import controller.states.State
import model.pieces.Piece
import util.Command

class MoveCommand(from: String, to: String, var controller: Controller) extends Command {
  var memento = new BoardMemento(controller)

  override def doStep(): Unit = {
    //memento = new BoardMemento()
    controller.state.move(from, to)
  }
  override def undoStep(): Unit = {
//    controller.createEmptyBoard()
    controller = memento.getController
//    controller.board.startPosition(memento.getController)
    //controller.board = controller.board.move(from, to)
  }
  override def redoStep(): Unit = {
    controller.state.move(from, to)
  }
}
