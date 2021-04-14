import model._

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    val board = new Board()
    val board2 = board.startPosition()
    println(board2)

  }
}