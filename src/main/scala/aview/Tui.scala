package aview

import model.Board

class Tui {

  def processInputLine(input: String, board:Board):Board = {
    input match {
      case "s" => board.startPosition()
      case "q" => board
    }
  }
}
