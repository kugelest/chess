package controller.controllerComponent.controllerBaseImpl

import com.google.inject.Inject
import controller.MoveCommand
import controller.controllerComponent.ControllerInterface
import controller.states.{State, White_Turn}
import model.BoardComponent.{BoardInterface, PieceInterface}
import util.{Observable, UndoManager}

class Controller @Inject() (var board: BoardInterface) extends Observable with ControllerInterface  {

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

  //def save: BoardInterface = {
    //fileIO.save(grid)
  //}

  //def load: BoardInterface = {

  //}

  def isManned(pos: String): Boolean = {
    board.getSquare(pos) match {
      case Some(square) => !square.isFree
      case _ => false
    }
  }

  def getPiece(pos: String): Option[PieceInterface] = {
    board.getPiece(pos)
  }

  def boardToString(): String = {
    board.toString
  }
}