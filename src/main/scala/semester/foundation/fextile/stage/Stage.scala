package semester.foundation.fextile.stage

import javafx.{event => fxe, stage => fxs}

import semester.foundation.fextile.application.Fextile
import semester.foundation.fextile.boundary.FextileDelegate
import semester.foundation.fextile.event.WindowEvent

import scala.concurrent.Future

class Stage
  extends Window
  with FextileDelegate[fxs.Stage] {

  override def createDelegate: fxs.Stage = new fxs.Stage()

  override def decorateDelegate[DD >: fxs.Stage](target: DD): Unit = {
    super.decorateDelegate(target)
    target match {
      case stage: fxs.Stage =>
        val issuer = this
        stage.addEventHandler(fxs.WindowEvent.ANY, new fxe.EventHandler[fxs.WindowEvent] {
          override def handle(event: fxs.WindowEvent): Unit = {
            Fextile.ref ! WindowEvent(event, issuer)
          }
        })
    }
  }

  def title: Future[String] = delegate(_.getTitle)

  def title_=(t: String): Unit = delegate(_.setTitle(t))

}
