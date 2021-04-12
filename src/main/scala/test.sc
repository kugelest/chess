
case class PlayGround(len: Integer = 8) {
  val vec = Vector.fill(len, len)("_")


  override def toString: String =  {
    val label: Vector[Char] = Vector.range('A', ('A' + len).toChar)
    val labelStr = String.format("%" + (len*2+3) + "s\n\n", label.mkString(" "))
    val fieldStr = String.format("%s", vec.zipWithIndex.map(k => String.format("%-4d%s%4d", len-k._2, k._1.mkString(" "), len-k._2)).mkString("\n"))
    labelStr + fieldStr + "\n\n" + labelStr
  }
}

val playground = PlayGround()
