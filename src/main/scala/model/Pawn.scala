package model

case class Pawn(pos: String, color: Char) extends Piece {

//  def move(to: String, board: Board): Board = {
//    board.removePiece(pos).setPiece(to, Pawn(to, color))
//  }

  def move(to: String, board: Board): Board = {
    val Current_file = pos.charAt(0)
    val Current_rank = pos.charAt(1).asDigit
    to.charAt(0) match {
      case Current_file => color match {
        case 'w' => to.charAt(1).asDigit - 1 match {
          case Current_rank =>  board.removePiece(pos).setPiece(Pawn(to, color))
          case _ => board
        }
        case 'b' => to.charAt(1).asDigit + 1 match {
          case Current_rank => board.removePiece(pos).setPiece(Pawn(to, color))
          case _ => board
        }
        case _ => board
      }
      case _ => board
    }
  }

  override def toString: String = {
    color match {
      case 'w' => "\u265F"
      case 'b' => "\u2659"
    }
  }
}
