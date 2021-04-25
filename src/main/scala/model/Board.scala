package model

case class Board(private val squares: Vector[Vector[Square]], turn: Char) {
  def this(len: Int = 8) = {
    this(Vector.tabulate(len, len)((i, k) => Square(('a'+k).toChar, len-i, None)), 'w')
  }
  val len: Int = squares.length




  def getSquare(pos: String): Square = {
    val file = pos.charAt(0)
    val rank = pos.charAt(1).asDigit
    squares(len-rank)(file-'a')
  }

  def setPiece(piece: Piece): Board = {

    val file = piece.pos.charAt(0)
    val rank = piece.pos.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, Some(piece)))))
  }

  def removePiece(pos: String): Board = {
    val file = pos.charAt(0)
    val rank = pos.charAt(1).asDigit
    copy(squares.updated(len-rank, squares(len-rank).updated(file-'a', Square(file, rank, None))))
  }

  def move(from: String, to: String): Board = {
    getSquare(from).getPiece match {
      case Some(piece) => piece.move(to, this)
      case None => this
    }
  }



  def startPosition(): Board = {
      //white
      this.setPiece(Rook("a1", 'w'))
        .setPiece(Knight("b1", 'w'))
        .setPiece(Bishop("c1", 'w'))
        .setPiece(Queen("d1", 'w'))
        .setPiece(King("e1", 'w'))
        .setPiece(Bishop("f1", 'w'))
        .setPiece(Knight("g1", 'w'))
        .setPiece(Rook("h1", 'w'))
        .setPiece(Pawn("a2", 'w'))
        .setPiece(Pawn("b2", 'w'))
        .setPiece(Pawn("c2", 'w'))
        .setPiece(Pawn("d2", 'w'))
        .setPiece(Pawn("e2", 'w'))
        .setPiece(Pawn("f2", 'w'))
        .setPiece(Pawn("g2", 'w'))
        .setPiece(Pawn("h2", 'w'))
      //black
        .setPiece(Rook("a8", 'b'))
        .setPiece(Knight("b8", 'b'))
        .setPiece(Bishop("c8", 'b'))
        .setPiece(Queen("d8", 'b'))
        .setPiece(King("e8", 'b'))
        .setPiece(Bishop("f8", 'b'))
        .setPiece(Knight("g8", 'b'))
        .setPiece(Rook("h8", 'b'))
        .setPiece(Pawn("a7", 'b'))
        .setPiece(Pawn("b7", 'b'))
        .setPiece(Pawn("c7", 'b'))
        .setPiece(Pawn("d7", 'b'))
        .setPiece(Pawn("e7", 'b'))
        .setPiece(Pawn("f7", 'b'))
        .setPiece(Pawn("g7", 'b'))
        .setPiece(Pawn("h7", 'b'))

  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.file).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.rank}%-4d", " ", f"${row.head.rank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}