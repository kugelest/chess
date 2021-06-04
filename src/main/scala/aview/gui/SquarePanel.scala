package aview.gui

import controller.{CellChanged, Controller}

import scala.swing._
import javax.swing.table._
import scala.swing.event._

class SquarePanel(pos: String, controller: Controller) extends FlowPanel {

  val backgroundColor = new Color(200, 200, 255)

  def cellText() = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else "+"

  val label =
    new Label {
      text = cellText()
    }

  val cell = new BoxPanel(Orientation.Vertical) {
    label.text = cellText()
    contents += label
    preferredSize = new Dimension(51, 51)
    background = backgroundColor
    border = Swing.BeveledBorder(Swing.Raised)
    repaint
  }

  def redraw = {
    contents.clear()
    label.text = cellText()
    contents += cell
    repaint()
  }
}
