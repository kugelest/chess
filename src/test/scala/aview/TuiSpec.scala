package aview

import controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import model._

class TuiSpec extends AnyWordSpec with Matchers{
  "A Tui" should {
    val tui = new Tui(new Controller(new Board()))
    "print out an ready Board on input 'start'" in {
      tui.processInputLine("start")
    }
    "exit the program on input 'quit'" in {
      tui.processInputLine("quit")
    }

  }
}
