package semester.foundation.fextile.event

import javafx.event.{Event => FXEvent}

trait Event[FXE <: FXEvent, I <: EventIssuer] {
  val fxEvent: FXE

  val issuer: I
}
