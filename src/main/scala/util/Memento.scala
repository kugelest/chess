package util

import model.pieces.Piece

trait Memento {
  def getPieces: Vector[Piece]
}
