import model._

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    var board = new Board()
    board = board.startPosition()
    board = board.removePiece("a1")
    board = board.removePiece("h2")
    board = board.getPiece("b2") match {
      case Some(piece) => piece.move("b4", "c4", board)
    }
    println(board)

  }
}