package htwg.se.chess

import com.google.inject.AbstractModule
import htwg.se.chess.controller.controllerComponent._
import htwg.se.chess.model.BoardComponent.BoardBaseImpl._
import htwg.se.chess.model.BoardComponent.BoardInterface
import htwg.se.chess.model.FileIOComponent._
import net.codingwell.scalaguice.ScalaModule

class ChessModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[ControllerInterface].to[controllerBaseImpl.Controller]
    bind[BoardInterface].toInstance(new Board(8))
    bind[FileIOInterface].to[FileIOXMLImpl.FileIO]
  }

}