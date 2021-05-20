package controller

import model.pieces.Piece
import util.Command

class MoveCommand(from: String, to: String, controller: Controller) extends Command {
  var memento = new BoardMemento(controller.board.B)

  override def doStep(): Unit = {
    //memento = new BoardMemento()
    controller.board = controller.board.move(from, to)
  }
  override def undoStep(): Unit = {
    controller.createEmptyBoard()
    controller.board.startPosition(memento.getPiece)
    //controller.board = controller.board.move(from, to)
  }
  override def redoStep(): Unit = {
    controller.board = controller.board.move(from, to)
  }
}
