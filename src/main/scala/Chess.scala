import model._
import aview.Tui

import scala.io.StdIn.readLine

object Chess {
  var board = new Board()
  val tui = new Tui

  def main(args: Array[String]): Unit = {
    var input: String = ""
    println("Board: \n" + board.toString)

    do {
      input = readLine()
      board = tui.processInputLine(input, board)
      println(board)
    } while(input != "q")

  }
}