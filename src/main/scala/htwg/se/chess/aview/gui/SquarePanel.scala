package htwg.se.chess.aview.gui

import htwg.se.chess.controller.controllerComponent.ControllerInterface

import javax.swing.BorderFactory
import scala.swing._
import scala.swing.event.MouseClicked

class SquarePanel(pos: String, controller: ControllerInterface, backgroundColor: Color) extends FlowPanel {

  def cellText(): String = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else " "

  val label: Label =
    new Label {
      text = cellText()
      font = new Font("Monospace", 0, 70)
    }

  val cell: BoxPanel = new BoxPanel(Orientation.Horizontal) {

    label.text = cellText()
    label.horizontalTextPosition = Alignment.Right
    contents += label
    listenTo(this)
    listenTo(mouse.clicks)
    reactions += {
      case e: MouseClicked => println(pos)

    }
    preferredSize = new Dimension(100, 100)
    background = backgroundColor
    border = BorderFactory.createEmptyBorder(0, 17, 15, 0)
    repaint
  }

  def redraw(): Unit = {
    contents.clear()
    label.text = cellText()
    contents += cell
    repaint()
  }
}
