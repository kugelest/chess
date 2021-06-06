package aview.gui

import controller.Controller

import scala.swing._
import javax.swing.table._
import scala.swing.event._

class SquarePanel(pos: String, controller: Controller) extends FlowPanel {

  val backgroundColor = new Color(200, 200, 255)

  def cellText(): String = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else "+"

  val label: Label =
    new Label {
      text = cellText()
    }

  val cell: BoxPanel = new BoxPanel(Orientation.Vertical) {
    label.text = cellText()
    contents += label
    preferredSize = new Dimension(51, 51)
    background = backgroundColor
    border = Swing.BeveledBorder(Swing.Raised)
    repaint
  }

  def redraw(): Unit = {
    contents.clear()
    label.text = cellText()
    contents += cell
    repaint()
  }
}
