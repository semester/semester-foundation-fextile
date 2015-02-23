package semester.foundation.fextile.application

import javafx.application.{Application => JavaFXApplication}

private[fextile]
case class ApplicationLauncher(app: FextileApp,
                               args: Array[String]) {

  def launch(): Unit = {
    ApplicationHelper.launcher = Some(this)
    JavaFXApplication.launch(classOf[ApplicationHelper], args: _*)
  }

  def enqueue(): Unit = {
    Fextile.ref ! this
  }
}
