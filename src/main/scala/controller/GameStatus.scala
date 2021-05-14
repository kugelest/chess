package controller

import model.Board

trait GameStatus {
  def move(from: String, to: String): Board
}

class White_Turn(controller: Controller) extends GameStatus {
  override def move(from: String, to: String): Board = {
    if (controller.board.whiteMovePossible(from, to)) {
      controller.board = controller.board.move(from, to)
      controller.setGameStatus(new Black_Turn(controller))
    }
  }
}

class Black_Turn(controller: Controller) extends GameStatus {
  override def move(from: String, to: String): Board = {
    if (controller.board.blackMovePossible(from, to)) {
      controller.board = controller.board.move(from, to)
      controller.setGameStatus(new White_Turn(controller))
    }
  }
}

//object GameStatus extends Enumeration {
//  type GameStatus = Value
//  val WIN_WHITE, WIN_BLACK, DRAW, WHITE_TURN, BLACK_TURN = Value
//
//  val map = Map[GameStatus, String](
//    WIN_WHITE -> "White has won the Match!",
//    WIN_BLACK -> "Black has won the Match!",
//    DRAW -> "Game ended in a draw!"
//  )
//
//  def message(gameStatus: GameStatus) = {
//    map(gameStatus)
//  }
//}
