package semester.foundation.fextile.event

import java.util.concurrent.Executors

import semester.foundation.fextile.application.Fextile

import scala.concurrent.{ExecutionContext, Future}

trait Event {
  val source: EventSource

  def enqueue(): Unit = {
    Future {
      Fextile.ref ! this
    }(Event.eventExecutor)
  }
}

object Event {
  val eventExecutor = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())
}