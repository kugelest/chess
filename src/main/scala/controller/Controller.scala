package controller

import model.Board
import util.Observable

class Controller(var board: Board) extends Observable{
  def createEmptyBoard(size: Int = 8):Unit = {
    board = new Board(size)
    notifyObservers()
  }

  def createStartPosition(): Unit = {
    board = board.startPosition()
    notifyObservers()
  }

  def move(from: String, to: String): Unit = {
    board = board.move(from, to)
    notifyObservers()
  }

  def boardToString():String = {
    board.toString
  }
}
