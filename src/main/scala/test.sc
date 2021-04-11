
case class PlayGround(len: Integer = 8) {
  val vec = Vector.fill(len, len)("_")


  override def toString: String =  {
    val label = "  A B C D E F G H"
    label + "\n" + vec.zipWithIndex.map(k => len-k._2 + " " + k._1.mkString(" ") + " " + (len-k._2)).mkString("\n") + "\n" + label
  }
}

val playground = PlayGround()
