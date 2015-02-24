package semester.foundation.fextile.event

import javafx.event.EventHandler
import javafx.{event => fxe}

trait UIEvent[FXE <: fxe.Event, ES <: EventSource]
  extends Event[ES] {

  val fxEvent: FXE

  def consume(): Unit = fxEvent.consume()
}

object UIEvent {
  def handler[E <: fxe.Event, S <: EventSource](source: S, h: (E, S) => UIEvent[E, S]) = {
    new EventHandler[E] {
      override def handle(event: E): Unit = {
        h(event, source).enqueue()
      }
    }
  }

  def decorateHandlers[E <: fxe.Event, S <: EventSource](source: S): Unit = {
  }
}