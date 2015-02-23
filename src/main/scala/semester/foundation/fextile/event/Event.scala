package semester.foundation.fextile.event

trait Event[I <: EventSource] {
  val issuer: I
}
