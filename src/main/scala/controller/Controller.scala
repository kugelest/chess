package controller

import controller.GameStatus.{BLACK_TURN, GameStatus, WHITE_TURN}
import model.Board
import util.Observable

class Controller(var board: Board, var gameStatus: GameStatus = WHITE_TURN) extends Observable{



  def createEmptyBoard(size: Int = 8):Unit = {
    board = new Board(size)
    notifyObservers()
  }

  def createStartPosition(): Unit = {
    board = new Board()
    board = board.startPosition()
    notifyObservers()
  }

  def move(from: String, to: String): Unit = {
    gameStatus match {
      case WHITE_TURN =>
        if (board.whiteMovePossible(from, to)) {
          board = board.move(from, to)
          gameStatus = BLACK_TURN
        }
      case BLACK_TURN =>
        if (board.blackMovePossible(from, to)) {
          board = board.move(from, to)
          gameStatus = WHITE_TURN
        }
      case _ =>
    }
    notifyObservers()
  }

  def boardToString(): String = {
    board.toString
  }
}
