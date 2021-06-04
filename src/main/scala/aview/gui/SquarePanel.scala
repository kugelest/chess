package aview.gui

import controller.Controller

import scala.swing._
import javax.swing.table._
import scala.swing.event._

class SquarePanel(pos: String, controller: Controller) extends FlowPanel {

  val backgroundColor = new Color(200, 200, 255)

  def cellText() = if (controller.isManned(pos)) " " + controller.getPiece(pos).get.toString else "-"

  val label =
    new Label {
      text = cellText()
//      font = new Font("Verdana", 1, 36)
    }

  val cell = new BoxPanel(Orientation.Vertical) {
    contents += label
    preferredSize = new Dimension(51, 51)
    background = backgroundColor
    border = Swing.BeveledBorder(Swing.Raised)
//    listenTo(mouse.clicks)
//    listenTo(controller)
  }

  def redraw = {
    contents.clear()
    label.text = cellText()
    contents += cell
    repaint
  }
}
