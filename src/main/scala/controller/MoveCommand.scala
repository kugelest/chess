package controller

import model.pieces.Piece
import util.Command

class MoveCommand(from: String, to: String, var controller: Controller) extends Command {
  var memento = new BoardMemento(controller.board)

  override def doStep(): Unit = {
    //memento = new BoardMemento()
    controller.board = controller.board.move(from, to)
  }
  override def undoStep(): Unit = {
//    controller.createEmptyBoard()
    controller.board = memento.getBoard
//    controller.board.startPosition(memento.getController)
    //controller.board = controller.board.move(from, to)
  }
  override def redoStep(): Unit = {
    controller.board = controller.board.move(from, to)
  }
}
