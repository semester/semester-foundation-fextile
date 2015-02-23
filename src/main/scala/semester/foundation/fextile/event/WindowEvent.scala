package semester.foundation.fextile.event

import javafx.{stage => fxs}

import semester.foundation.fextile.stage.Stage

trait WindowEvent
  extends UIEvent[javafx.stage.WindowEvent, Stage]

case class WindowCloseRequest(fxEvent: fxs.WindowEvent,
                              issuer: Stage)
  extends WindowEvent

case class WindowHidden(fxEvent: fxs.WindowEvent,
                        issuer: Stage)
  extends WindowEvent

case class WindowHiding(fxEvent: fxs.WindowEvent,
                        issuer: Stage)
  extends WindowEvent

case class WindowShown(fxEvent: fxs.WindowEvent,
                       issuer: Stage)
  extends WindowEvent

case class WindowShowing(fxEvent: fxs.WindowEvent,
                         issuer: Stage)
  extends WindowEvent

object WindowEvent {
  def apply(fxEvent: fxs.WindowEvent,
            issuer: Stage): WindowEvent = {
    fxEvent.getEventType match {
      case fxs.WindowEvent.WINDOW_CLOSE_REQUEST =>
        WindowCloseRequest(fxEvent, issuer)
      case fxs.WindowEvent.WINDOW_HIDDEN =>
        WindowHidden(fxEvent, issuer)
      case fxs.WindowEvent.WINDOW_HIDING =>
        WindowHiding(fxEvent, issuer)
      case fxs.WindowEvent.WINDOW_SHOWN =>
        WindowShown(fxEvent, issuer)
      case fxs.WindowEvent.WINDOW_SHOWING =>
        WindowShowing(fxEvent, issuer)
    }
  }
}