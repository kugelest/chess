package util

import controller.states.State
import model.BoardComponent.BoardBaseImpl.Board

trait Memento {
  def getState: State
  def getBoard: Board
}
