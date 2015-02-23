package semester.foundation.fextile.application

import javafx.application.Platform

import akka.actor._
import semester.foundation.fextile.event.ApplicationWillLaunch

class Fextile extends Actor with Stash {
  private var appActor: Option[ActorRef] = None

  def receive: Receive = {
    case launcher: ApplicationLauncher =>
      val actor = Fextile.system.actorOf(launcher.app.props)
      appActor = Some(actor)

      actor ! ApplicationWillLaunch(launcher.app, launcher.args)
      launcher.launch()

      unstashAll()

    case e =>
      appActor match {
        case Some(app) => app ! e
        case None => stash()
      }
  }
}

object Fextile {
  def shutdown() = {
    system.shutdown()
    Platform.exit()
  }

  val system = ActorSystem("fextile")

  val ref = system.actorOf(Props[Fextile])
}
