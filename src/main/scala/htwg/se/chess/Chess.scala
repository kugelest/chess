package htwg.se.chess

import com.google.inject.Guice
import htwg.se.chess.aview.Tui
import htwg.se.chess.aview.gui.SwingGui
import htwg.se.chess.controller.controllerComponent.ControllerInterface
import htwg.se.chess.model.FileIOComponent.FileIOService

import scala.io.StdIn.readLine

object Chess {
  val injector = Guice.createInjector(new ChessModule)
  val controller = injector.getInstance(classOf[ControllerInterface])

  val tui = new Tui(controller)
  val gui = new SwingGui(controller)
  FileIOService.main
  controller.notifyObservers()

  @main
  def main(): Unit = {
    var input: String = ""

    input = readLine()
    tui.processInputLine(input)
    while (input != "quit") {
      input = readLine()
      tui.processInputLine(input)
    }
  }
}
