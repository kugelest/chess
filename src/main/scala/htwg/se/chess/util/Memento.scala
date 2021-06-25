package htwg.se.chess.util

import htwg.se.chess.controller.states.State
import htwg.se.chess.model.BoardComponent.BoardInterface

trait Memento {
  def getState: State

  def getBoard: BoardInterface
}
