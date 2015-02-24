package semester.foundation.fextile.event

import semester.foundation.fextile.application.Fextile

trait Event[I <: EventSource] {
  val issuer: I

  def enqueue(): Unit = {
    Fextile.ref ! this
  }
}
