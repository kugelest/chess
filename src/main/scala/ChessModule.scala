  import com.google.inject.AbstractModule
  import net.codingwell.scalaguice.ScalaModule
  import controller.controllerComponent._
  import model.BoardComponent.{BoardInterface, PieceInterface, SquareInterface}
  import model.BoardComponent.BoardBaseImpl._

  class ChessModule extends AbstractModule with ScalaModule {

    override def configure() = {
      bind[BoardInterface].to[Board]
      bind[SquareInterface].to[Square]
      bind[PieceInterface].to[Piece]
      bind[ControllerInterface].to[controllerBaseImpl.Controller]

    }

}