  import com.google.inject.AbstractModule
  import net.codingwell.scalaguice.ScalaModule
  import controller.controllerComponent._
  import model.BoardComponent.{BoardInterface, PieceInterface, SquareInterface}
  import model.BoardComponent.BoardBaseImpl._
  import model.BoardComponent.BoardBaseImpl.pieces._

  class ChessModule extends AbstractModule with ScalaModule {
    override def configure() = {
//      bind[PieceInterface].toInstance()
//      bind[BoardInterface].to[Board]
//      bind[SquareInterface].to[Square]
      bind[ControllerInterface].to[controllerBaseImpl.Controller]
      bind[BoardInterface].toInstance(new Board(8))



//      bind[Piece].toInstance(new Gameboard(defaultSizeX,defaultSizeY))
//      bindConstant().annotatedWith(Names.named("DefaultSize")).to(defaultSize)
//      bind[GridInterface].annotatedWithName("tiny").toInstance(new Grid(1))
//bind[WinStrategy].annotatedWithName("OnePin").toInstance(new OnePinWinStrategy)
    }

}