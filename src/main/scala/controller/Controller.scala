package controller

import controller.states.{State, White_Turn}
import model.Board
import util.Observable

class Controller(var board: Board) extends Observable {

  var state: State = White_Turn(this)

  def setState(newState: State): Unit = {
    state = newState
  }

  def createEmptyBoard(size: Int = 8):Unit = {
    state.createEmptyBoard(size)
    notifyObservers()
  }

  def move(from: String, to: String): Unit = {
    state.move(from, to)
    notifyObservers()
  }

  def createStartPosition(): Unit = {
    state.createStartPosition()
    notifyObservers()
  }

  def boardToString(): String = {
    board.toString
  }
}
