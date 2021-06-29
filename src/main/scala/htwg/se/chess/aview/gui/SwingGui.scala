package htwg.se.chess.aview.gui

import htwg.se.chess.controller.controllerComponent.ControllerInterface
import htwg.se.chess.util.Observer

import java.awt.Color
import javax.swing.BorderFactory
import scala.swing._
import scala.swing.event.MouseClicked


class SwingGui(controller: ControllerInterface) extends Frame with Observer {

  controller.add(this)
  controller.createStartPosition()

  var fromSet = false
  var from = ""
  var to = ""

  title = "Chess"
  //var cells: Array[Array[SquarePanel]] = Array.ofDim[SquarePanel](8, 8)
  var cells = Array.ofDim[Label](8, 8)

  minimumSize = new Dimension(800, 800)

  def BoardPanel: GridPanel = new GridPanel(8, 8) {
    for {
      rank <- 0 until 8
      file <- 0 until 8
    } {
      val panel = new GridPanel(1, 1){
        if(rank % 2 == 1)
          if (file % 2 == 1) background = Color.WHITE
          else background = Color.LIGHT_GRAY
        else if ( file % 2 == 0) background = Color.WHITE
        else background = Color.LIGHT_GRAY

        val pos = ('a' + file).toChar.toString.concat((8 - rank).toString)
        def cellText(): String = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else " "

        val label: Label = new Label {
          text = cellText()
          font = new Font("Monospace", 0, 75)
          preferredSize = new Dimension(50, 50)
        }
        contents += label
        cells(rank)(file) = label

        update()
        listenTo(this)
        listenTo(mouse.clicks)
        reactions += {
          case e: MouseClicked => {
            if(!fromSet){
              fromSet = true
              from = pos
            } else {
              fromSet = false
              to = pos
              controller.move(from, to)
            }
          }
        }
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
      contents += new MenuItem(Action("Save")(controller.save))
      contents += new MenuItem(Action("Load")(controller.load))
      contents += new MenuItem(Action("Close")(System.exit(0)))
    }
    contents += new Menu("Edit") {
      contents += new MenuItem(Action("Undo")(controller.undo()))
      contents += new MenuItem(Action("Redo")(controller.redo()))
    }
  }

  visible = true

  override def update(): Boolean = {
    for {
      rank <- 0 until 8
      file <- 0 until 8
    } {
      //val pos = ('a' + file).toChar.toString.concat((8 - rank).toString)
      //cells(rank)(file).text = if (controller.isManned(pos)) controller.getPiece(pos).get.toString else " "
    }
    repaint()
    true
  }


}
