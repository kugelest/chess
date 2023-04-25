package htwg.se.chess.model.FileIOComponent

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route

object FileIOService {

  val route = path("fileio") {
    get {
      complete("Test")
    }
  }

  val server = Http().newServerAt("localhost", 8080).bind(route)
  server.map  {
    _ => println("Server online at http://localhost:8080/")
  }

}
