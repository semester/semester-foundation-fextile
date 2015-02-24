package semester.foundation.fextile.event

import javafx.{stage => fxs}

import semester.foundation.fextile.stage.Window

trait WindowEvent
  extends UIEvent[fxs.WindowEvent, Window]

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

object WindowEvent {
  def decorateHandlers(source: Window, target: fxs.Window): Unit = {
    target.setOnCloseRequest(UIEvent.handler[fxs.WindowEvent, Window](source, WindowCloseRequest))
    target.setOnHidden(UIEvent.handler[fxs.WindowEvent, Window](source, WindowHidden))
    target.setOnHiding(UIEvent.handler[fxs.WindowEvent, Window](source, WindowHiding))
    target.setOnShown(UIEvent.handler[fxs.WindowEvent, Window](source, WindowShown))
    target.setOnShowing(UIEvent.handler[fxs.WindowEvent, Window](source, WindowShowing))
  }
}