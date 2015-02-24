package semester.foundation.fextile.event

import semester.foundation.fextile.application.Fextile

trait Event {
  val source: EventSource

  def enqueue(): Unit = {
    Fextile.ref ! this
  }
}
