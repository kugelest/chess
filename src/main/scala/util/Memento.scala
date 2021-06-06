package util

import controller.states.State
import model.BoardComponent.BoardBaseImpl.Board
import model.BoardComponent.BoardInterface

trait Memento {
  def getState: State
  def getBoard: BoardInterface
}
