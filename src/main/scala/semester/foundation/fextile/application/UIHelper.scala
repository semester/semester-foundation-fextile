package semester.foundation.fextile.application

import akka.actor.{ActorRef, Actor}
import semester.foundation.fextile.boundary.FextileProxy
import semester.foundation.fextile.event.Event

class UIHelper(appActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case proxy: FextileProxy[_] =>
      proxy.execute()

    case event: Event[_, _] =>
      appActor ! event
  }
}
