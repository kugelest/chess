package aview

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import model._

class TuiSpec extends AnyWordSpec with Matchers{
  "A Tui" should {
    var board = new Board()
    val tui = new Tui()
    "print out an ready Board on input 's'" in {
      tui.processInputLine("s", board)
    }
    "exit the program on input 'q'" in {
      tui.processInputLine("q", board)
    }

  }
}
