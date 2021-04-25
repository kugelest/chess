package aview

import model.Board

class Tui {

  def processInputLine(input: String, board:Board):Board = {
    input match {
      case "s" => board.startPosition()
      case "q" => board
      case input if input.contains("move") =>
        val from2 = s"${input(5)}${input(6)}"
        val to = s"${input(8)}${input(9)}"

        board.move(from2, to)
    }
  }


//  def checkInput(from: String, to: String): String = {
//    val from = input.f
//  }
}
