package semester.foundation.fextile.event

import javafx.event.{Event => FXEvent}

trait UIEvent[FXE <: FXEvent, I <: EventIssuer]
  extends Event[I] {

  val fxEvent: FXE

  def consume(): Unit = fxEvent.consume()
}
