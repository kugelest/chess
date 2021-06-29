package htwg.se.chess.controller.controllerComponent


import htwg.se.chess.controller.states.State
import htwg.se.chess.model.BoardComponent.PieceInterface
import htwg.se.chess.util.Observable

trait ControllerInterface extends Observable {

  def setState(newState: State): Unit

  def createEmptyBoard(size: Int = 8): Unit

  def move(from: String, to: String): Unit

  def createStartPosition(): Unit

  def undo(): Unit

  def redo(): Unit

  def save: Unit

  def load: Unit

  def isManned(pos: String): Boolean

  def getPiece(pos: String): Option[PieceInterface]

  def boardToString(): String

}
