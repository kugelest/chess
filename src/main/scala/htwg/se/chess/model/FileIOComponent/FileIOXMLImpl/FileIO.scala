package htwg.se.chess.model.FileIOComponent.FileIOXMLImpl

import htwg.se.chess.model.BoardComponent.BoardInterface
import htwg.se.chess.model.FileIOComponent.FileIOInterface

import scala.xml.{Elem, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def load: BoardInterface = {
    val board: BoardInterface = null
    val file = scala.xml.XML.loadFile("board.xml")
    val squares = file \\ "square"
    for (square <- squares) {
      val pos: String = (square \ "@pos").text
      val piece = (square \ "value").text
      piece match {
        case "value = ♗" => println("Bishop")
      }
    }
    board
  }

  def save(board: BoardInterface): Unit = saveString(board)

  def saveXML(board: BoardInterface): Unit = {
    scala.xml.XML.save("board.xml", boardToXml(board))
  }

  def saveString(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.xml"))
    val pp = new PrettyPrinter(120, 4)
    val xml = pp.format(boardToXml(board))
    pw.write(xml)
    pw.close()
  }

  def boardToXml(board: BoardInterface): Elem = {
    <board>
      {
      for {
        rank <- 0 until 8
        file <- 0 until 8
      } yield {
        val pos = ('a' + file).toChar.toString.concat((8 - rank).toString)
        squareToXml(board, pos)
        }
      }
    </board>
  }

  def squareToXml(board: BoardInterface, pos: String): Elem = {
    val piece = board.getPiece(pos)
    val xmlSquare = {
      <square pos={pos}>
        value = {
        piece match {
          case Some(value) => value.toString
          case None => ""
          }
        }
      </square>
    }
    xmlSquare
  }
}
