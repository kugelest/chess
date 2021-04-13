case class Square(file: Char, rank: Int, value: Char = '-') {
  override def toString: String = {
    value.toString
  }
}


case class Board(len: Int = 15) {
  val files = Vector.range('A', ('A' + len).toChar)
  val ranks = Vector.range(1, len + 1)
  val squares = Vector.tabulate(len, len)((i, k) => Square(files(k), ranks(len - i - 1)))



  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", files.mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}

val playground = Board()
