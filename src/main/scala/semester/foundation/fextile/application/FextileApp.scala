package semester.foundation.fextile.application

import akka.actor.Props
import semester.foundation.fextile.event.EventIssuer
import semester.foundation.fextile.stage.PrimaryStage

trait FextileApp extends EventIssuer {
  def props: Props

  var stage: PrimaryStage = null

  def main(args: Array[String]): Unit = {
    ApplicationLauncher(this, args).enqueue()
  }
}
