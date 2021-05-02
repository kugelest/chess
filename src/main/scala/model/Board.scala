package model

case class Board(private val squares: Vector[Vector[Square]], whichTurn: Char) {

  def this(len: Int = 8) = this(Vector.tabulate(len, len)((i, k) => Square(s"${('a'+k).toChar}${len-i}", None)), 'w')

  val len: Int = squares.length

  def getSquare(pos: String): Square = squares(len-pos(1).asDigit)(pos(0)-'a')
  def setPiece(piece: Piece): Board = copy(squares.updated(len-piece.getRank, squares(len-piece.getRank).updated(piece.getFile-'a', Square(piece.pos, Some(piece)))))
  def removePiece(pos: String): Board = copy(squares.updated(len-pos(1).asDigit, squares(len-pos(1).asDigit).updated(pos(0)-'a', Square(pos, None))))
  def setTurn(turn: Char): Board = if(List('w', 'b').contains(turn)) copy(whichTurn = turn) else this

  def moveWhite(from: String, to: String): Board = {
    getSquare(from).piece match {
      case Some(piece) => if (piece.color == 'w') piece.move(to, copy(whichTurn = 'b')) else this
      case _ => this
    }
  }

  def moveBlack(from: String, to: String): Board = {
    getSquare(from).piece match {
      case Some(piece) => if (piece.color == 'b') piece.move(to, copy(whichTurn = 'w')) else this
      case _ => this
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
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.getFile).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.getRank}%-4d", " ", f"${row.head.getRank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}