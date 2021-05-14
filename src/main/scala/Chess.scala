import model._
import aview.Tui
import controller.Controller
import controller.states.White_Turn

import scala.io.StdIn.readLine

object Chess {
  val controller = new Controller(new Board(8))
  val tui = new Tui(controller)
  controller.notifyObservers()

  def main(args: Array[String]): Unit = {
      var input: String = ""

      do {
        input = readLine()
        tui.processInputLine(input)
      } while (input != "quit")
    }
}