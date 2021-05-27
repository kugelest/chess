package util

import controller.states.State
import model.Board

trait Memento {
  def getState: State
  def getBoard: Board
}
