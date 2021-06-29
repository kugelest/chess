package htwg.se.chess.model.FileIOComponent

import htwg.se.chess.model.BoardComponent.BoardInterface

trait FileIOInterface {

  def load: BoardInterface

  def save(board: BoardInterface): Unit

}
