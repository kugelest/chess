package model

case class Board(private val squares: Vector[Vector[Square]], whichTurn: Char) {

  def this(len: Int = 8) = this(Vector.tabulate(len, len)((i, k) => Square(s"${('a'+k).toChar}${len-i}", None)), 'w')

  val len: Int = squares.length

  def getSquare(pos: String): Square = squares(len-pos(1).asDigit)(pos(0)-'a')
  def setPiece(piece: Piece): Board = copy(squares.updated(len-piece.getRank, squares(len-piece.getRank).updated(piece.getFile-'a', Square(piece.pos, Some(piece)))))
  def removePiece(pos: String): Board = copy(squares.updated(len-pos(1).asDigit, squares(len-pos(1).asDigit).updated(pos(0)-'a', Square(pos, None))))
  def setTurn(turn: Char): Board = if(List('w', 'b').contains(turn)) copy(whichTurn = turn) else this


  def whiteMovePossible(from: String, to: String): Boolean = {
    getSquare(from).piece match {
      case Some(piece) => piece.whiteMovePossible(to, this)
      case _ => false
    }
  }

  def blackMovePossible(from: String, to: String): Boolean = {
    getSquare(from).piece match {
      case Some(piece) => piece.blackMovePossible(to, this)
      case _ => false
    }
  }


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
      this.setPiece(Piece("rook", "a1", 'w'))
        .setPiece(Piece("knight", "b1", 'w'))
        .setPiece(Piece("bishop", "c1", 'w'))
        .setPiece(Piece("queen", "d1", 'w'))
        .setPiece(Piece("king", "e1", 'w'))
        .setPiece(Piece("bishop", "f1", 'w'))
        .setPiece(Piece("knight", "g1", 'w'))
        .setPiece(Piece("rook", "h1", 'w'))
        .setPiece(Piece("pawn", "a2", 'w'))
        .setPiece(Piece("pawn", "b2", 'w'))
        .setPiece(Piece("pawn", "c2", 'w'))
        .setPiece(Piece("pawn", "d2", 'w'))
        .setPiece(Piece("pawn", "e2", 'w'))
        .setPiece(Piece("pawn", "f2", 'w'))
        .setPiece(Piece("pawn", "g2", 'w'))
        .setPiece(Piece("pawn", "h2", 'w'))
      //black
        .setPiece(Piece("rook", "a8", 'b'))
        .setPiece(Piece("knight", "b8", 'b'))
        .setPiece(Piece("bishop", "c8", 'b'))
        .setPiece(Piece("queen", "d8", 'b'))
        .setPiece(Piece("king", "e8", 'b'))
        .setPiece(Piece("bishop", "f8", 'b'))
        .setPiece(Piece("knight", "g8", 'b'))
        .setPiece(Piece("rook", "h8", 'b'))
        .setPiece(Piece("pawn", "a7", 'b'))
        .setPiece(Piece("pawn", "b7", 'b'))
        .setPiece(Piece("pawn", "c7", 'b'))
        .setPiece(Piece("pawn", "d7", 'b'))
        .setPiece(Piece("pawn", "e7", 'b'))
        .setPiece(Piece("pawn", "f7", 'b'))
        .setPiece(Piece("pawn", "g7", 'b'))
        .setPiece(Piece("pawn", "h7", 'b'))
  }

  override def toString: String =  {
    val filesStr = String.format("%" + (len*2+3) + "s\n\n", squares.head.map(_.getFile).mkString(" "))
    val ranksAndSquaresStr = squares.map(row => row.mkString(f"${row.head.getRank}%-4d", " ", f"${row.head.getRank}%4d"))
    ranksAndSquaresStr.mkString(filesStr, "\n", s"\n\n$filesStr")
  }
}