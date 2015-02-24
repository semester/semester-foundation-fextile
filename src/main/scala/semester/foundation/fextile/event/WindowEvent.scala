package semester.foundation.fextile.event

import javafx.{stage => fxs}

import semester.foundation.fextile.stage.Window

trait WindowEvent
  extends UIEvent[javafx.stage.WindowEvent, Window]

case class WindowCloseRequest(fxEvent: fxs.WindowEvent,
                              issuer: Window)
  extends WindowEvent

case class WindowHidden(fxEvent: fxs.WindowEvent,
                        issuer: Window)
  extends WindowEvent

case class WindowHiding(fxEvent: fxs.WindowEvent,
                        issuer: Window)
  extends WindowEvent

case class WindowShown(fxEvent: fxs.WindowEvent,
                       issuer: Window)
  extends WindowEvent

case class WindowShowing(fxEvent: fxs.WindowEvent,
                         issuer: Window)
  extends WindowEvent
