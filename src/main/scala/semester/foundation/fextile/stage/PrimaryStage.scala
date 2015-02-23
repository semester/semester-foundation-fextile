package semester.foundation.fextile.stage

import javafx.stage

import semester.foundation.fextile.application.ApplicationHelper
import semester.foundation.fextile.event.EventSource

import scala.concurrent.Future

class PrimaryStage
  extends Stage {

  override val supervisor: Future[EventSource] = Future {
    ApplicationHelper.launcher.get.app
  }

  override val delegate: Future[stage.Stage] = Future {
    decorate(ApplicationHelper.stage.get)(decorateWindowEvent)
  }
}
