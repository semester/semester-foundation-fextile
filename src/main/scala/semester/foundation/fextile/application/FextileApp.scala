package semester.foundation.fextile.application

import akka.actor.Props
import semester.foundation.fextile.event.EventIssuer
import semester.foundation.fextile.stage.PrimaryStage

trait FextileApp extends EventIssuer {
  var stage: PrimaryStage = null

  override def props: Option[Props] = Some(Props[ApplicationDefault])

  def main(args: Array[String]): Unit = {
    ApplicationLauncher(this, args).enqueue()
  }
}
