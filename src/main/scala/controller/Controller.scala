package controller

import model.Board
import util.Observable

class Controller(var board: Board, var gameStatus: GameStatus) extends Observable {

  def this(board: Board) = this(board, new White_Turn(this))

  def setGameStatus(newStatus: GameStatus): Unit = {
    gameStatus = newStatus
  }

  def createEmptyBoard(size: Int = 8):Unit = {
    board = new Board(size)
    notifyObservers()
  }

//  def createStartPosition(): Unit = {
//    createEmptyBoard()
//    board = board.startPosition()
//    gameStatus = WHITE_TURN
//    notifyObservers()
//  }
//
//  def move(from: String, to: String): Unit = {
//    gameStatus match {
//      case WHITE_TURN =>
//        if (board.whiteMovePossible(from, to)) {
//          board = board.move(from, to)
//          gameStatus = BLACK_TURN
//        }
//      case BLACK_TURN =>
//        if (board.blackMovePossible(from, to)) {
//          board = board.move(from, to)
//          gameStatus = WHITE_TURN
//        }
//      case _ =>
//    }
//    notifyObservers()
//  }

  def boardToString(): String = {
    board.toString
  }
}
