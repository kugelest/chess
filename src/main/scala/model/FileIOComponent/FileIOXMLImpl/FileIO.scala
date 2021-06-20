package model.FileIOComponent.FileIOXMLImpl

import com.google.inject.Guice
import model.BoardComponent.BoardInterface
import model.FileIOComponent.FileIOInterface

import java.io.PrintWriter
import scala.xml.PrettyPrinter

class FileIO extends FileIOInterface{

  override def load: BoardInterface = {
    var board: BoardInterface = null
    val file = scala.xml.XML.loadFile("board.xml")
    val injector = Guice.createInjector(new ChessModule)
    val squares = (file \\ "square")
    // for schleife
    board
  }

  def save(board: BoardInterface): Unit = saveString(board)

  def saveXML(board: BoardInterface): Unit = {
    scala.xml.XML.save("board.xml", boardToXml(board))
  }

  def saveString(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(boardToXml(board))
    pw.write(xml)
    pw.close
  }

  def boardToXml(board: BoardInterface) = {
    <board>
      {
        for{
          row <- 0 until 8
          col <- 0 until 8
        } yield {
          squareToXml(board, row, col)
        }
      }
    </board>
  }

  def squareToXml(board: BoardInterface, row: Int, Col: Int) = {
    <square>
    </square>
  }
}
