package semester.foundation.fextile.stage

import javafx.{event => fxe, stage => fxs}

import semester.foundation.fextile.application.Fextile
import semester.foundation.fextile.boundary.FextileDelegate
import semester.foundation.fextile.event.WindowEvent

import scala.concurrent.Future

class Stage
  extends FextileDelegate[fxs.Stage] {

  override val delegate: Future[fxs.Stage] = Future {
    decorate(new fxs.Stage())(decorateWindowEvent)
  }

  def decorateWindowEvent(stage: fxs.Stage) = {
    val issuer = this
    stage.addEventHandler(fxs.WindowEvent.ANY, new fxe.EventHandler[fxs.WindowEvent] {
      override def handle(event: fxs.WindowEvent): Unit = {
        Fextile.ref ! WindowEvent(event, issuer)
      }
    })
  }

  //
  //  def scene: Scene = __scene.get()
  //  def scene_=(s: Scene): Unit = {
  //    __scene.set(s)
  //  }
  //
  def title: Future[String] = delegate(_.getTitle)

  def title_=(t: String): Unit = delegate(_.setTitle(t))

  def width: Future[Double] = delegate(_.getWidth)

  def width_=(w: Double): Unit = delegate(_.setWidth(w))

  def height: Future[Double] = delegate(_.getHeight)

  def height_=(h: Double): Unit = delegate(_.setHeight(h))
}
