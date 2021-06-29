package htwg.se.chess.model.FileIOComponent.FileIOXMLImpl

import htwg.se.chess.model.BoardComponent.BoardBaseImpl.{Board, Piece}
import htwg.se.chess.model.BoardComponent.BoardInterface
import htwg.se.chess.model.FileIOComponent.FileIOInterface

import scala.xml.{Elem, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def load: BoardInterface = {
    var board: BoardInterface = new Board(8)
    val file = scala.xml.XML.loadFile("board.xml")
    val squares = file \\ "square"
    for (square <- squares) {
      val pos: String = (square \ "@pos").text
      val piece = square.text
      piece match {
        case " value = ♗ " => board = board.setPiece(Piece("bishop", pos, 'w'))
        case " value = ♔ " => board = board.setPiece(Piece("king", pos, 'w'))
        case " value = ♘ " => board = board.setPiece(Piece("knight", pos, 'w'))
        case " value = ♙ " => board = board.setPiece(Piece("pawn", pos, 'w'))
        case " value = ♕ " => board = board.setPiece(Piece("queen", pos, 'w'))
        case " value = ♖ " => board = board.setPiece(Piece("rook", pos, 'w'))
        case " value = ♝ " => board = board.setPiece(Piece("bishop", pos, 'b'))
        case " value = ♚ " => board = board.setPiece(Piece("king", pos, 'b'))
        case " value = ♞ " => board = board.setPiece(Piece("knight", pos, 'b'))
        case " value = ♟ " => board = board.setPiece(Piece("pawn", pos, 'b'))
        case " value = ♛ " => board = board.setPiece(Piece("queen", pos, 'b'))
        case " value = ♜ " => board = board.setPiece(Piece("rook", pos, 'b'))
        case _ =>
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
      {for {
      rank <- 0 until 8
      file <- 0 until 8
    } yield {
      val pos = ('a' + file).toChar.toString.concat((8 - rank).toString)
      squareToXml(board, pos)
    }}
    </board>
  }

  def squareToXml(board: BoardInterface, pos: String): Elem = {
    val piece = board.getPiece(pos)
    val xmlSquare = {
      <square pos={pos}>
        value =
        {piece match {
        case Some(value) => value.toString
        case None => ""
      }}
      </square>
    }
    xmlSquare
  }
}