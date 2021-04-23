import model._

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    var board = new Board()
    board = board.startPosition()
    board = board.removePiece("a1")
    println(board)

  }
}