package controller.states

import controller.Controller
import model.Board

trait State {
  def controller: Controller
  def move(from: String, to: String): Unit

  def createEmptyBoard(size: Int): Unit = {
    controller.board = new Board(size)
    controller.setState(White_Turn(controller))
  }

  def createStartPosition(): Unit = {
    createEmptyBoard(8)
    controller.board = controller.board.startPosition()
    controller.setState(White_Turn(controller))
  }
}

