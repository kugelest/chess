package model

case class Board(squares: Vector[Vector[Square]], turn: Char) {
  def this(len: Int = 8) = {
    this(Vector.tabulate(len, len)((i, k) => Square(('a'+k).toChar, len-i, None)), 'w')
  }
  val len: Int = squares.length



  def getPiece(pos: String): Option[Piece] = {
    val file = pos.charAt(0)
    val rank = pos.charAt(1).asDigit
    squares(len-rank)(file-'a').value
  }

  def setPiece(pos: String, piece: Piece): Board = {

    val file = pos.charAt(0)
    val rank = pos.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, Some(piece)))))
  }

  def removePiece(pos: String): Board = {
    val file = pos.charAt(0)
    val rank = pos.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, None))))
  }

  def move(from: String, to: String): Board = {
    getPiece(from) match {
      case Some(piece) => piece.move(to, this)
      case None => this
    }
  }

  def startPosition(): Board = {
      //white
      this.setPiece("a1", Rook("a1", 'w'))
        .setPiece("b1", Knight("b1", 'w'))
        .setPiece("c1", Bishop("c1", 'w'))
        .setPiece("d1", Queen("d1", 'w'))
        .setPiece("e1", King("e1", 'w'))
        .setPiece("f1", Bishop("f1", 'w'))
        .setPiece("g1", Knight("g1", 'w'))
        .setPiece("h1", Rook("h1", 'w'))
        .setPiece("a2", Pawn("a2", 'w'))
        .setPiece("b2", Pawn("b2", 'w'))
        .setPiece("c2", Pawn("c2", 'w'))
        .setPiece("d2", Pawn("d2", 'w'))
        .setPiece("e2", Pawn("e2", 'w'))
        .setPiece("f2", Pawn("f2", 'w'))
        .setPiece("g2", Pawn("g2", 'w'))
        .setPiece("h2", Pawn("h2", 'w'))
      //black
        .setPiece("a8", Rook("a8", 'b'))
        .setPiece("b8", Knight("b8", 'b'))
        .setPiece("c8", Bishop("c8", 'b'))
        .setPiece("d8", Queen("d8", 'b'))
        .setPiece("e8", King("e8", 'b'))
        .setPiece("f8", Bishop("f8", 'b'))
        .setPiece("g8", Knight("g8", 'b'))
        .setPiece("h8", Rook("h8", 'b'))
        .setPiece("a7", Pawn("a7", 'b'))
        .setPiece("b7", Pawn("b7", 'b'))
        .setPiece("c7", Pawn("c7", 'b'))
        .setPiece("d7", Pawn("d7", 'b'))
        .setPiece("e7", Pawn("e7", 'b'))
        .setPiece("f7", Pawn("f7", 'b'))
        .setPiece("g7", Pawn("g7", 'b'))
        .setPiece("h7", Pawn("h7", 'b'))

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}