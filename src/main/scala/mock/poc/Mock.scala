package mock.poc

import javafx.scene.paint.Color

import akka.actor.{Actor, Props}
import semester.foundation.fextile.application.{Fextile, FextileApp}
import semester.foundation.fextile.event.{WindowHidden, MouseClicked}
import semester.foundation.fextile.scene.Scene
import semester.foundation.fextile.stage.PrimaryStage

class Mock extends Actor {
  override def receive: Receive = {
    case (s: Scene, e: MouseClicked) =>
      s.fill = Color.RED

    case (_, _: WindowHidden) =>
      Fextile.shutdown()
  }
}

object Mock extends FextileApp {

  class PrimaryMock extends Actor {
    override def receive: Actor.Receive = {
      case e =>
        println(s"primary mock: $e")
    }
  }

  val mainScene = new Scene {
    fill = Color.BLUE
  }

  stage = new PrimaryStage {
    title = "Mock"
    width = 800
    height = 600
    scene = mainScene
  }

  override def props: Option[Props] = Some(Props[Mock])
}
