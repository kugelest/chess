package model

case class Board(squares: Vector[Vector[Square]]) {
  def this(len: Int = 8) = {
    this(Vector.tabulate(len, len)((i, k) => Square(('A'+k).toChar, len-i, None)))
  }
  val len: Int = squares.length



  def setPiece(file: Char, rank: Int, piece: Piece): Board = {
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'A', Square(file, rank, Some(piece)))))
  }

  def startPosition(): Board = {
      //white
      this.setPiece('A', 1, Rook('w'))
        .setPiece('B', 1, Knight('w'))
        .setPiece('C', 1, Bishop('w'))
        .setPiece('D', 1, Queen('w'))
        .setPiece('E', 1, King('w'))
        .setPiece('F', 1, Bishop('w'))
        .setPiece('G', 1, Knight('w'))
        .setPiece('H', 1, Rook('w'))
        .setPiece('A', 2, Pawn('w'))
        .setPiece('B', 2, Pawn('w'))
        .setPiece('C', 2, Pawn('w'))
        .setPiece('D', 2, Pawn('w'))
        .setPiece('E', 2, Pawn('w'))
        .setPiece('F', 2, Pawn('w'))
        .setPiece('G', 2, Pawn('w'))
        .setPiece('H', 2, Pawn('w'))
      //black
        .setPiece('A', 8, Rook('b'))
        .setPiece('B', 8, Knight('b'))
        .setPiece('C', 8, Bishop('b'))
        .setPiece('D', 8, Queen('b'))
        .setPiece('E', 8, King('b'))
        .setPiece('F', 8, Bishop('b'))
        .setPiece('G', 8, Knight('b'))
        .setPiece('H', 8, Rook('b'))
        .setPiece('A', 7, Pawn('b'))
        .setPiece('B', 7, Pawn('b'))
        .setPiece('C', 7, Pawn('b'))
        .setPiece('D', 7, Pawn('b'))
        .setPiece('E', 7, Pawn('b'))
        .setPiece('F', 7, Pawn('b'))
        .setPiece('G', 7, Pawn('b'))
        .setPiece('H', 7, Pawn('b'))

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}