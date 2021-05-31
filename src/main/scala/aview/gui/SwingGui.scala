package aview.gui

import scala.swing._
import controller._
import util.Observer

import java.awt.Color
import javax.swing.BorderFactory


class SwingGui(controller: Controller) extends Frame with Observer {
  controller.add(this)

  val LabelSquare = new Dimension(75, 75)
  val LabelRank = new Dimension(50, 75)
  val LabelFile = new Dimension(75, 50)

  title = "Chess"
  minimumSize = new Dimension(1280, 960)

  def BoardPanel = new GridPanel(8, 8) {
    for (i <- Range(0, 64)) {
      val cell = i % 8
      val row = Integer2int(7 - i / 8)

      val panel = new GridPanel(1, 1) {
        if (cell % 2 == 1)
          if (row % 2 == 1) background = Color.WHITE
          else background = Color.BLACK
        else if (row % 2 == 0) background = Color.WHITE
        else background = Color.BLACK
        minimumSize = LabelSquare
      }
      contents += panel
    }
  }

  def labelRank: GridPanel = new GridPanel(8, 1) {
    for (i <- Range(8, 0, -1)) {
      contents += new Label {
        font = new Font("Monospace", 2, 20)
        text = i.toString
        preferredSize = LabelRank
      }
    }
  }

  def labelFile: GridPanel = new GridPanel(1, 9) {

    border = BorderFactory.createEmptyBorder(0, 50, 0, 50)
    for (i <- List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H')) {
      contents += new Label {
        font = new Font("Monospace", 2, 20)
        horizontalAlignment = Alignment.Center
        text = i.toString
        preferredSize = LabelFile
      }
    }
  }

  contents =
    new BorderPanel {
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

  override def update: Boolean = {true}
}
