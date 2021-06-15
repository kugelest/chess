import aview.Tui
import aview.gui.SwingGui
import controller.Controller
import model.BoardComponent.BoardBaseImpl.Board
import scala.io.StdIn.readLine
import com.google.inject.Guice

object Chess {
  val injector = Guice.createInjector(new SudokuModule)
  val controller = injector.getInstance(classOf[ControllerInterface])


//  val controller = new Controller(new Board(8))
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