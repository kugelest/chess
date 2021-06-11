package aview.gui

import controller.Controller

import javax.swing.BorderFactory
import scala.swing._
import javax.swing.table._
import scala.swing.event._

class SquarePanel(pos: String, controller: Controller, backgroundColor: Color) extends FlowPanel {

  def cellText(): String = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else " "

  val label: Label =
    new Label {
      text = cellText()
      font = new Font("Arial", 0, 70)
    }

  val cell: BoxPanel = new BoxPanel(Orientation.Horizontal) {
    label.text = cellText()
    label.horizontalTextPosition = Alignment.Right
    contents += label
    preferredSize = new Dimension(100, 100)
    background = backgroundColor
    border = BorderFactory.createEmptyBorder(0,17,15,0)
    repaint
  }

  def redraw(): Unit = {
    contents.clear()
    label.text = cellText()
    contents += cell
    repaint()
  }
}
