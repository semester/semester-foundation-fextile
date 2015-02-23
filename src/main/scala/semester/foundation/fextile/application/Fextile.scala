package semester.foundation.fextile.application

import akka.actor._

class Fextile extends Actor with Stash {
  private var appActor: Option[ActorRef] = None

  def receive: Receive = {
    case launcher: ApplicationLauncher =>
      appActor = Some(Fextile.system.actorOf(launcher.app.props))
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
  val system = ActorSystem("fextile")

  val ref = system.actorOf(Props[Fextile])
}
