case class Cell(file: Char, rank: Int, value: Char = '-') {
  override def toString: String = {
    value.toString
  }
}


case class PlayGround(len: Int = 8) {
  val files = Vector.range('A', ('A' + len).toChar)
  val ranks = Vector.range(1, len + 1)
  val vec = Vector.tabulate(len, len)((i, k) => Cell(files(k), ranks(len - i - 1)))

  override def toString: String =  {

    val labelStr = String.format("%" + (len*2+3) + "s\n\n", files.mkString(" "))
//    val fieldStr = vec.mk
    val fieldStr = vec.zipWithIndex.map(k => String.format("%-4d%s%4d", len-k._2, k._1.mkString(" "), len-k._2)).mkString("\n")
    labelStr + fieldStr + "\n\n" + labelStr
  }
}

val playground = PlayGround()
