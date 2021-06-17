package controller.states

import controller.controllerComponent.controllerBaseImpl.Controller

case class White_Turn(controller: Controller) extends State {
  override def move(from: String, to: String): Unit = {
    if (controller.board.whiteMovePossible(from, to)) {
      controller.board = controller.board.move(from, to)
      controller.setState(Black_Turn(controller))
    }
  }
}