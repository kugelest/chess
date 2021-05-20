package util

import controller.Controller
import controller.states.State
import model.Board
import model.pieces.Piece

trait Memento {
  def getState: State
}
