package controller

import controller.states.{State, White_Turn}
import model.Board
import model.pieces.Piece
import util.{Observable, UndoManager}

class Controller(var board: Board) extends Observable {

  var state: State = White_Turn(this)
  private val undoManager = new UndoManager

  def setState(newState: State): Unit = {
    state = newState
  }

  def createEmptyBoard(size: Int = 8):Unit = {
    state.createEmptyBoard(size)
    notifyObservers()
  }

  def move(from: String, to: String): Unit = {
    undoManager.doStep(new MoveCommand(from, to, this))
    notifyObservers()
  }

  def createStartPosition(): Unit = {
    state.createStartPosition()
    notifyObservers()
  }

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers()
  }

  def isManned(pos: String): Boolean = {
    board.getSquare(pos) match {
      case Some(square) => !square.isFree
      case _ => false
    }
  }

  def getPiece(pos: String): Option[Piece] = {
    board.getPiece(pos)
  }

  def boardToString(): String = {
    board.toString
  }
}
