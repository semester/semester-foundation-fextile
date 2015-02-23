package semester.foundation.fextile.event

trait Event[I <: EventIssuer] {
  val issuer: I
}
