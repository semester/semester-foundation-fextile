package semester.foundation.fextile.stage

import javafx.stage

import semester.foundation.fextile.application.ApplicationHelper

import scala.concurrent.Future

class PrimaryStage
  extends Stage {

  override val delegate: Future[stage.Stage] = Future {
    decorate(ApplicationHelper.stage.get)(decorateWindowEvent)
  }
}
