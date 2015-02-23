package semester.foundation.fextile.event

import javafx.stage.{WindowEvent => FXWindowEvent}

import semester.foundation.fextile.stage.Stage

trait WindowEvent
  extends UIEvent[javafx.stage.WindowEvent, Stage]

case class WindowCloseRequest(fxEvent: FXWindowEvent,
                              issuer: Stage)
  extends WindowEvent

case class WindowHidden(fxEvent: FXWindowEvent,
                        issuer: Stage)
  extends WindowEvent

case class WindowHiding(fxEvent: FXWindowEvent,
                        issuer: Stage)
  extends WindowEvent

case class WindowShown(fxEvent: FXWindowEvent,
                       issuer: Stage)
  extends WindowEvent

case class WindowShowing(fxEvent: FXWindowEvent,
                         issuer: Stage)
  extends WindowEvent

object WindowEvent {
  def apply(fxEvent: FXWindowEvent,
            issuer: Stage): WindowEvent = {
    fxEvent.getEventType match {
      case FXWindowEvent.WINDOW_CLOSE_REQUEST =>
        WindowCloseRequest(fxEvent, issuer)
      case FXWindowEvent.WINDOW_HIDDEN =>
        WindowHidden(fxEvent, issuer)
      case FXWindowEvent.WINDOW_HIDING =>
        WindowHiding(fxEvent, issuer)
      case FXWindowEvent.WINDOW_SHOWN =>
        WindowShown(fxEvent, issuer)
      case FXWindowEvent.WINDOW_SHOWING =>
        WindowShowing(fxEvent, issuer)
    }
  }
}