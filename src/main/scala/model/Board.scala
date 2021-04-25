package model

case class Board(squares: Vector[Vector[Square]], turn: Char) {
  def this(len: Int = 8) = {
    this(Vector.tabulate(len, len)((i, k) => Square(('a'+k).toChar, len-i, None)), 'w')
  }
  val len: Int = squares.length



  def getPiece(coord: String): Option[Piece] = {
    val file = coord.charAt(0)
    val rank = coord.charAt(1).asDigit
    squares(len-rank)(file-'a').value
  }

  def setPiece(coord: String, piece: Piece): Board = {

    val file = coord.charAt(0)
    val rank = coord.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, Some(piece)))))
  }

  def removePiece(coord: String): Board = {
    val file = coord.charAt(0)
    val rank = coord.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, None))))
  }



  def startPosition(): Board = {
      //white
      this.setPiece("a1", Rook('w'))
        .setPiece("b1", Knight('w'))
        .setPiece("c1", Bishop('w'))
        .setPiece("d1", Queen('w'))
        .setPiece("e1", King('w'))
        .setPiece("f1", Bishop('w'))
        .setPiece("g1", Knight('w'))
        .setPiece("h1", Rook('w'))
        .setPiece("a2", Pawn('w'))
        .setPiece("b2", Pawn('w'))
        .setPiece("c2", Pawn('w'))
        .setPiece("d2", Pawn('w'))
        .setPiece("e2", Pawn('w'))
        .setPiece("f2", Pawn('w'))
        .setPiece("g2", Pawn('w'))
        .setPiece("h2", Pawn('w'))
      //black
        .setPiece("a8", Rook('b'))
        .setPiece("b8", Knight('b'))
        .setPiece("c8", Bishop('b'))
        .setPiece("d8", Queen('b'))
        .setPiece("e8", King('b'))
        .setPiece("f8", Bishop('b'))
        .setPiece("g8", Knight('b'))
        .setPiece("h8", Rook('b'))
        .setPiece("a7", Pawn('b'))
        .setPiece("b7", Pawn('b'))
        .setPiece("c7", Pawn('b'))
        .setPiece("d7", Pawn('b'))
        .setPiece("e7", Pawn('b'))
        .setPiece("f7", Pawn('b'))
        .setPiece("g7", Pawn('b'))
        .setPiece("h7", Pawn('b'))

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}