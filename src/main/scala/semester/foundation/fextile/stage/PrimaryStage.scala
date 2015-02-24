package semester.foundation.fextile.stage

import javafx.{stage => fxs}

import semester.foundation.fextile.application.ApplicationHelper
import semester.foundation.fextile.event.EventSource

import scala.concurrent.Future

class PrimaryStage
  extends Stage {

  override val supervisor: Future[EventSource] = Future {
    ApplicationHelper.launcher.get.app
  }

  override def createDelegate: fxs.Stage = {
    ApplicationHelper.stage.get
  }
}
