package semester.foundation.fextile.event

import semester.foundation.fextile.stage.Stage

case class WindowEvent(fxEvent: javafx.stage.WindowEvent,
                       issuer: Stage)
  extends UIEvent[javafx.stage.WindowEvent, Stage]
