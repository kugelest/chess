package model

case class Board(squares: Vector[Vector[Square]]) {
  def this(len: Int = 8) = {
    this(Vector.tabulate(len, len)((i, k) => Square(('A'+k).toChar, len-i)))
  }
  val len: Int = squares.length



  def setPiece(file: Char, rank: Int, piece: Char): Board = {
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'A', Square(file, rank, piece)) ))
  }

  def startPosition(): Board = {
      //white
      this.setPiece('A', 1, 0x265C)
        .setPiece('B', 1, 0x265E)
        .setPiece('C', 1, 0x265D)
        .setPiece('D', 1, 0x265B)
        .setPiece('E', 1, 0x265A)
        .setPiece('F', 1, 0x265D)
        .setPiece('G', 1, 0x265E)
        .setPiece('H', 1, 0x265C)
        .setPiece('A', 2, 0x265F)
        .setPiece('B', 2, 0x265F)
        .setPiece('C', 2, 0x265F)
        .setPiece('D', 2, 0x265F)
        .setPiece('E', 2, 0x265F)
        .setPiece('F', 2, 0x265F)
        .setPiece('G', 2, 0x265F)
        .setPiece('H', 2, 0x265F)
      //black
        .setPiece('A', 8, 0x2656)
        .setPiece('B', 8, 0x2658)
        .setPiece('C', 8, 0x2657)
        .setPiece('D', 8, 0x2655)
        .setPiece('E', 8, 0x2654)
        .setPiece('F', 8, 0x2657)
        .setPiece('G', 8, 0x2658)
        .setPiece('H', 8, 0x2656)
        .setPiece('A', 7, 0x2659)
        .setPiece('B', 7, 0x2659)
        .setPiece('C', 7, 0x2659)
        .setPiece('D', 7, 0x2659)
        .setPiece('E', 7, 0x2659)
        .setPiece('F', 7, 0x2659)
        .setPiece('G', 7, 0x2659)
        .setPiece('H', 7, 0x2659)

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}