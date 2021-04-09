import model.Playground

object Chess {
  def main(args: Array[String]): Unit = {
    println("Chess")

    val pp = Playground().playgroundString()
    println(pp)
  }
}