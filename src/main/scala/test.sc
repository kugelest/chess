
case class PlayGround(len: Integer = 8) {
  val vec = Vector.fill(len, len)("_")

  override def toString(): String =  {
    vec.map(k => k.mkString(" ")).mkString("\n") + "\na b c d e f g h"
  }
}

val playground = PlayGround()
