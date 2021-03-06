package htwg.se.chess.controller

import htwg.se.chess.controller.controllerComponent.controllerBaseImpl.Controller
import htwg.se.chess.util.Command

class MoveCommand(from: String, to: String, val controller: Controller) extends Command {
  var memento = new BoardMemento(controller.state, controller.board)

  override def doStep(): Unit = {
    controller.state.move(from, to)
  }

  override def undoStep(): Unit = {
    controller.state = memento.getState
    controller.board = memento.getBoard
  }

  override def redoStep(): Unit = {
    controller.state.move(from, to)
  }
}
