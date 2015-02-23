package mock.poc

import akka.actor.{Actor, Props}
import semester.foundation.fextile.application.{Fextile, FextileApp}
import semester.foundation.fextile.event.WindowHidden
import semester.foundation.fextile.stage.PrimaryStage

class Mock extends Actor {
  override def receive: Receive = {
    case _: WindowHidden =>
      Fextile.shutdown()

    case e =>
      println(s"mock: $e")
  }
}

object Mock extends FextileApp {

  stage = new PrimaryStage {
    title = "Mock"
    width = 800
    height = 600
  }

  override def props: Props = Props[Mock]
}
