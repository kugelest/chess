package aview

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import model._
import controller.Controller

class TuiSpec extends AnyWordSpec with Matchers{
  "A Tui" should {
    val tui = new Tui(new Controller(new Board()))
    "print out an ready Board on input 'start'" in {
      tui.processInputLine("start")
    }
    "exit the program on input 'quit'" in {
      tui.processInputLine("quit")
    }
    "empty the board on input 'empty'" in {
      tui.processInputLine("empty")
    }
    "move a piece on input 'move from to'" in {
      tui.processInputLine("move a2 a3")
    }
    "do nothing on wrong input" in {
      tui.processInputLine(" ")
    }
  }
}
