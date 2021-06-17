package controller.controllerComponent


import controller.MoveCommand
import controller.states.{State, White_Turn}
import model.BoardComponent.{BoardInterface, PieceInterface}

trait ControllerInterface {

  def setState(newState: State): Unit

  def createEmptyBoard(size: Int = 8): Unit

  def move(from: String, to: String): Unit

  def createStartPosition(): Unit

  def undo(): Unit

  def redo(): Unit

  def isManned(pos: String): Boolean

  def getPiece(pos: String): Option[PieceInterface]

  def boardToString(): String

}
