
case class PlayGround(len: Integer = 8) {
  val vec = Vector.fill(len, len)("_")


  override def toString: String =  {
    "  a b c d e f g h\n" + vec.zipWithIndex.map(k => k._2 + " " + k._1.mkString(" ") + " " + k._2).mkString("\n") + "\n  a b c d e f g h"
  }
}

val playground = PlayGround()
