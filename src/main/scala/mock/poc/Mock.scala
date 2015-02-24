package mock.poc

import javafx.scene.paint.Color

import akka.actor.{Actor, Props}
import semester.foundation.fextile.application.FextileApp
import semester.foundation.fextile.event.{MouseMoved, MouseClicked}
import semester.foundation.fextile.scene.Scene
import semester.foundation.fextile.stage.PrimaryStage

class Mock extends Actor {
  override def receive: Receive = {
    case e: MouseMoved =>
      e.source match {
        case s: Scene =>
          s.fill = Color.RED
      }

    case e =>
      println(s"mock: $e")
  }
}

object Mock extends FextileApp {

  class PrimaryMock extends Actor {
    override def receive: Actor.Receive = {
      case e =>
        println(s"primary mock: $e")
    }
  }

  stage = new PrimaryStage {
    title = "Mock"
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.BLUE
    }
  }

  override def props: Option[Props] = Some(Props[Mock])
}
