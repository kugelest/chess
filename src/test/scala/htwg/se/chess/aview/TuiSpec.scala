package htwg.se.chess.aview

import htwg.se.chess.controller.controllerComponent.controllerBaseImpl.Controller
import htwg.se.chess.model.BoardComponent.BoardBaseImpl.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

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
    "undo a move on input 'undo'" in {
      tui.processInputLine("undo")
    }
    "redo a move on input 'redo'" in {
      tui.processInputLine("redo")
    }
    "save the game on input 'save'" in {
      tui.processInputLine("save")
    }
    "load the game on input 'load'" in {
      tui.processInputLine("load")
    }
  }
}
