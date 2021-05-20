package util

import controller.Controller
import model.Board
import model.pieces.Piece

trait Memento {
  def getBoard: Board
}
