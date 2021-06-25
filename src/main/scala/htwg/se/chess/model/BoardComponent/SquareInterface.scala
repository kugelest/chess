package htwg.se.chess.model.BoardComponent

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Piece

trait SquareInterface {
  def pos: String
  def piece: Piece
  def isFree: Boolean
}