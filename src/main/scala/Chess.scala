import aview.Tui
import aview.gui.SwingGui
import controller.Controller
import model.BoardComponent.BoardBaseImpl.Board
import scala.io.StdIn.readLine

object Chess {
  val controller = new Controller(new Board(8))
  val tui = new Tui(controller)
  val gui = new SwingGui(controller)
  controller.notifyObservers()

  def main(args: Array[String]): Unit = {
      var input: String = ""

      do {
        input = readLine()
        tui.processInputLine(input)
      } while (input != "quit")
    }
}