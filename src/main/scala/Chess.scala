import model.Playground

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    val pp = Playground(8,8).playgroundString()
    println(pp)
  }
}