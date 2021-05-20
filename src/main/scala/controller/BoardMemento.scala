package controller

import controller.states.State
import model.Board
import model.pieces.Piece
import util.Memento

class BoardMemento(controller: Controller) extends Memento {
//  private val chessboard =  board

  override def getController: Controller = {
    controller
  }
}
