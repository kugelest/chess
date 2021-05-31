package aview.gui

import controller._
import util.Observer

import scala.swing._

import java.awt.Color
import javax.swing.BorderFactory


class SwingGui(controller: Controller) extends Frame with Observer {

  controller.add(this)

  title = "Chess"
  minimumSize = new Dimension(640, 360)

  def BoardPanel: GridPanel = new GridPanel(8, 8) {
    for (i <- Range(0, 64)) {
      val cell = i % 8
      val row = Integer2int(7 - i / 8)

      val panel = new GridPanel(1, 1) {
        if (cell % 2 == 1)
          if (row % 2 == 1) background = Color.WHITE
          else background = Color.BLACK
        else if (row % 2 == 0) background = Color.WHITE
        else background = Color.BLACK
        minimumSize = new Dimension(50, 50)
      }
      contents += panel
    }
  }

  def labelRank: GridPanel = new GridPanel(8, 1) {
    for (i <- Range(8, 0, -1)) {
      contents += new Label {
        text = i.toString
        preferredSize = new Dimension(25, 50)
      }
    }
  }

  def labelFile: GridPanel = new GridPanel(1, 9) {
    border = BorderFactory.createEmptyBorder(0, 25, 0, 25)
    for (i <- List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H')) {
      contents += new Label {
        horizontalAlignment = Alignment.Center
        text = i.toString
        preferredSize = new Dimension(50, 25)
      }
    }
  }

  contents = new BorderPanel {
      add(BoardPanel, BorderPanel.Position.Center)
      add(labelFile, BorderPanel.Position.North)
      add(labelFile, BorderPanel.Position.South)
      add(labelRank, BorderPanel.Position.East)
      add(labelRank, BorderPanel.Position.West)
    }

  menuBar = new MenuBar {
    contents += new Menu("File") {
      contents += new MenuItem(Action("New")(controller.createEmptyBoard()))
      contents += new MenuItem(Action("Start")(controller.createStartPosition()))
      contents += new MenuItem(Action("Close")(System.exit(0)))
    }
    contents += new Menu("Edit") {
      contents += new MenuItem(Action("Undo")(controller.undo()))
      contents += new MenuItem(Action("Redo")(controller.redo()))
    }
  }

  visible = true

  override def update(): Boolean = {true}
}
