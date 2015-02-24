package semester.foundation.fextile.event

import akka.actor.{ActorRef, Props}
import semester.foundation.fextile.application.Fextile

trait EventSource {
  def props: Option[Props] = None

  private[fextile] var supervisor: Option[EventSource] = None

  def actor: Option[ActorRef] = props map {
    p =>
      Fextile.system.actorOf(p)
  }

  def currentActor: ActorRef = {
    actor match {
      case Some(a) => a
      case None =>
        supervisor match {
          case Some(s) => s.currentActor
          case None => Fextile.appDefault
        }
    }
  }
}
