package model

case class Player(name: String = "Max Mustermann") {
  override def toString:String = name

  def isSet: Boolean = name != ""
}
