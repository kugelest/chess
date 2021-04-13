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
      this.setPiece('A', 1, 'R')
        .setPiece('B', 1, 'N')
        .setPiece('C', 1, 'B')
        .setPiece('D', 1, 'Q')
        .setPiece('E', 1, 'K')
        .setPiece('F', 1, 'B')
        .setPiece('G', 1, 'N')
        .setPiece('H', 1, 'R')
        .setPiece('A', 2, 'P')
        .setPiece('B', 2, 'P')
        .setPiece('C', 2, 'P')
        .setPiece('D', 2, 'P')
        .setPiece('E', 2, 'P')
        .setPiece('F', 2, 'P')
        .setPiece('G', 2, 'P')
        .setPiece('H', 2, 'P')
      //black
        .setPiece('A', 8, 'r')
        .setPiece('B', 8, 'n')
        .setPiece('C', 8, 'b')
        .setPiece('D', 8, 'q')
        .setPiece('E', 8, 'k')
        .setPiece('F', 8, 'b')
        .setPiece('G', 8, 'n')
        .setPiece('H', 8, 'r')
        .setPiece('A', 7, 'p')
        .setPiece('B', 7, 'p')
        .setPiece('C', 7, 'p')
        .setPiece('D', 7, 'p')
        .setPiece('E', 7, 'p')
        .setPiece('F', 7, 'p')
        .setPiece('G', 7, 'p')
        .setPiece('H', 7, 'p')

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}