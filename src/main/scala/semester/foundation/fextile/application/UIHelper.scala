package semester.foundation.fextile.application

import akka.actor.{Actor, ActorRef}
import semester.foundation.fextile.event.UIEvent

class UIHelper(appActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case event: UIEvent[_, _] =>
      appActor ! event
  }
}
