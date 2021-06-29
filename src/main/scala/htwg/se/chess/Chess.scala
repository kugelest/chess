package htwg.se.chess

import com.google.inject.Guice
import htwg.se.chess.aview.Tui
import htwg.se.chess.aview.gui.SwingGui
import htwg.se.chess.controller.controllerComponent.ControllerInterface

import scala.io.StdIn.readLine

object Chess {
  val injector = Guice.createInjector(new ChessModule)
  val controller = injector.getInstance(classOf[ControllerInterface])

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
