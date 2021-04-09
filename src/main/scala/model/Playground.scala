package model

case class Playground(width: Int=8, height: Int=8){
  def widthAndHeightSsSet: Boolean = width != 0 & height != 0

  def playgroundString(): String= {
    var line = ""
    var pg = "  "
    var currentNum = ""

    for (x <- 1 to width){
      pg = pg.concat(("A"(0) + x - 1).toChar.toString + "  ")
      line = line.concat(" . ")
    }

    for (x <- 1 to height){
      currentNum = currentNum.concat(x.toString + line + x.toString + "\n")
    }
    "%s\n%s%s".format(pg, currentNum, pg)
  }
}
