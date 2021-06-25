package htwg.se.chess.model.FileIOComponent.FileIOJSONImpl

import htwg.se.chess.model.BoardComponent.{BoardInterface, PieceInterface, SquareInterface}
import htwg.se.chess.model.FileIOComponent.FileIOInterface
import play.api.libs.json._

class FileIO extends FileIOInterface{

  override def load: BoardInterface = ???

  override def save(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.json"))
    pw.write(Json.prettyPrint(boardToJson(board)))
    pw.close()
  }

  implicit val pieceWrites: Writes[PieceInterface] = new Writes[PieceInterface] {
    def writes(piece: PieceInterface): JsObject = Json.obj(
      "pos" -> piece.getPos,
      "color" -> piece.getColor.toString,
      "kind" -> piece.kind
    )
  }
  implicit val squareWrites: Writes[SquareInterface] = new Writes[SquareInterface] {
    def writes(square: SquareInterface): JsObject = Json.obj(
      "pos" -> square.pos,
      "piece" -> square.piece
    )
  }

  def boardToJson(board: BoardInterface): JsObject = {
    Json.obj(
      "board" -> Json.obj(
        "squares" -> Json.toJson(
          for {
            file <- 'a' to 'h'
            rank <- 0 until 8
          } yield {
            Json.obj(
              "file" -> file.toString,
              "rank" -> rank,
              "square" -> Json.toJson(board.getSquare(file.toString + "" + rank))
            )
          }
        )
      )
    )
  }
}