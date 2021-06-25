package htwg.se.chess.controller.controllerComponent.controllerBaseImpl

import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._
import htwg.se.chess.controller.MoveCommand
import htwg.se.chess.controller.controllerComponent.ControllerInterface
import htwg.se.chess.controller.states.{State, White_Turn}
import htwg.se.chess.model.BoardComponent.{BoardInterface, PieceInterface}
import htwg.se.chess.model.FileIOComponent.FileIOInterface
import htwg.se.chess.ChessModule
import htwg.se.chess.util.UndoManager

class Controller @Inject()(var board: BoardInterface) extends ControllerInterface {

  var state: State = White_Turn(this)
  private val undoManager = new UndoManager
  val injector = Guice.createInjector(new ChessModule)
  val fileIO = injector.instance[FileIOInterface]

  def setState(newState: State): Unit = {
    state = newState
  }

  def createEmptyBoard(size: Int = 8): Unit = {
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

  def save: Unit = {
    fileIO.save(board)
  }

  def load: Unit = {
    board = fileIO.load
  }

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
