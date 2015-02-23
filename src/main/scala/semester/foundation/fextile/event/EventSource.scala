package semester.foundation.fextile.event

import akka.actor.{ActorRef, Props}
import semester.foundation.fextile.application.Fextile

import scala.concurrent.Future

trait EventSource {
  def props: Option[Props] = None

  def supervisor: Future[EventSource] = Future.successful(EventSource.sourceRoot)

  def actor: Option[ActorRef] = props map {
    p =>
      Fextile.system.actorOf(p)
  }

  def currentActor: Future[ActorRef] = {
    implicit val executor = Fextile.system.dispatcher
    actor match {
      case Some(a) => Future.successful(a)
      case None =>
        supervisor flatMap {
          s =>
            s.currentActor
        }
    }
  }
}

object EventSource {
  val sourceRoot = new EventSource {
    override def actor: Option[ActorRef] = Some(Fextile.appDefault)
  }
}