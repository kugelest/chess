package aview

import controller.Controller
import model.Board
import util.Observer

class Tui(controller: Controller) extends Observer {

   controller.add(this)

  def processInputLine(input: String):Unit = {
    input match {
      case "quit" =>
      case "empty" => controller.createEmptyBoard()
      case "start" => controller.createStartPosition()
      case x if x.contains("move") => controller.move(x.slice(5, 7), x.slice(8, 10))
    }
  }

  override def update(): Unit =  println(controller.boardToString())

}
