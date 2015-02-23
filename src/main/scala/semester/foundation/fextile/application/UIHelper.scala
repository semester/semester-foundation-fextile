package semester.foundation.fextile.application

import akka.actor.{Actor, ActorRef}
import semester.foundation.fextile.event.Event

class UIHelper(appActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case event: Event[_, _] =>
      appActor ! event
  }
}
