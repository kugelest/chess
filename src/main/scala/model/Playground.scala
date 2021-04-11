package model

case class Playground(){

  def playgroundString(): String= {
    var line = ""
    var pg = "  "
    var currentNum = ""

    for (x <- 1 to 8){
      pg = pg.concat(("A"(0) + x - 1).toChar.toString + "  ")
      line = line.concat(" . ")
    }

    for (x <- 1 to 8){
      currentNum = currentNum.concat(x.toString + line + x.toString + "\n")
    }
    "%s\n%s%s".format(pg, currentNum, pg)
  }
}
