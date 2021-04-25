import model.Board

val board = new Board()
val board2 = board.startPosition()
 //   println(board2)

case class Piece(name: Char, color: Char) {
  override def toString: String = {
    (name, color) match {
      case ('R', 'w') => "\u265C"
      case ('N', 'w') => "\u265E"
      case ('B', 'w') => "\u265D"
      case ('Q', 'w') => "\u265B"
      case ('K', 'w') => "\u265A"
      case ('P', 'w') => "\u265F"

      case ('R', 'b') => "\u2656"
      case ('N', 'b') => "\u2658"
      case ('B', 'b') => "\u2657"
      case ('Q', 'b') => "\u2655"
      case ('K', 'b') => "\u2654"
      case ('P', 'b') => "\u2659"
    }
  }
}

val pawn1 = Piece('P', 'b')
val pawn2 = Piece('P', 'w')
val queen = Piece('Q', 'b')
val king = Piece('K', 'w')

println(pawn1)
println(pawn2)