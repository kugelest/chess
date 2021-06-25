package htwg.se.chess.aview

import htwg.se.chess.controller.controllerComponent.ControllerInterface
import htwg.se.chess.util.Observer

import scala.util.matching.Regex

class Tui(controller: ControllerInterface) extends Observer {
  controller.add(this)

  val Move: Regex = "(move [a-h][1-8] [a-h][1-8])".r

  def processInputLine(input: String): Unit = {
    input match {
      case "quit" =>
      case "empty" => controller.createEmptyBoard()
      case "start" => controller.createStartPosition()
      case "undo" => controller.undo()
      case "redo" => controller.redo()
      case "save" => controller.save
      case "load" => controller.load
      case Move(str) =>
        val fromTo = str.split(" ").takeRight(2)
        controller.move(fromTo(0), fromTo(1))
      case _ => println("Wrong input!")
    }
  }

  override def update(): Boolean = {
    println(controller.boardToString()); true
  }

}
