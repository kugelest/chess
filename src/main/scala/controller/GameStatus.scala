package controller

object GameStatus extends Enumeration {
  type GameStatus = Value
  val WIN_WHITE, WIN_BLACK, DRAW, WHITE_TURN, BLACK_TURN = Value

  val map = Map[GameStatus, String](
    WIN_WHITE -> "White has won the Match!",
    WIN_BLACK -> "Black has won the Match!",
    DRAW -> "Game ended in a draw!"
  )

  def message(gameStatus: GameStatus) = {
    map(gameStatus)
  }
}
