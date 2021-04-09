case class Cell(x:Int, y:Int)

val cell1 = Cell(4,5)
cell1.x
cell1.y

case class Field(cells: Array[Cell]) {
  val width = 5
  val height = 5
  def widthandHeightisset: Boolean = width != 0 & height != 0

  override def toString: String = {
    """RNBQKBNR
      |PPPPPPPP
      |________
      |________
      |________
      |________
      |PPPPPPPP
      |RNBQKBNR
      |""".stripMargin
  }
}

val field1 = Field(Array.ofDim[Cell](64))
field1.cells(0)=cell1
field1.cells(0).x
field1.cells(0).y
field1.cells(0)
field1.cells(63)

case class Player(color: String) {
  override def toString:String = color
}

val player1 = Player("white")
val player2 = Player("black")
player1
