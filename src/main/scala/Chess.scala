import model._

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    var board = new Board()
    board = board.startPosition()
//    board = board.removePiece("a1")
//    board = board.removePiece("h2")
    board = board.move("b6", "b5")
    println(board)

  }
}