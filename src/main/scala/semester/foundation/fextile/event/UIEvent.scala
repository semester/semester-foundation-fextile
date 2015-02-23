package semester.foundation.fextile.event

import javafx.{event => fxe}

trait UIEvent[FXE <: fxe.Event, ES <: EventSource]
  extends Event[ES] {

  val fxEvent: FXE

  def consume(): Unit = fxEvent.consume()
}
