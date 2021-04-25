import model._

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    var board = new Board()
    board = board.startPosition()
//    board = board.removePiece("a1")
//    board = board.removePiece("h2")
    board = board.move("b2", "b3")
    board = board.move("b3", "b4")
    board = board.move("b4", "b5")
    board = board.move("b5", "b6")
    board = board.move("b6", "b7")

    println(board)

  }
}