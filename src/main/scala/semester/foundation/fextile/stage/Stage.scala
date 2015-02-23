package semester.foundation.fextile.stage

import javafx.event.EventHandler
import javafx.stage.{Stage => FXStage, WindowEvent => FXWindowEvent}

import semester.foundation.fextile.application.Fextile
import semester.foundation.fextile.boundary.FextileDelegate
import semester.foundation.fextile.event.WindowEvent

import scala.concurrent.Future

class Stage
  extends FextileDelegate[FXStage] {

  override val delegate: Future[FXStage] = Future {
    decorate(new FXStage())(decorateWindowEvent)
  }

  def decorateWindowEvent(stage: FXStage) = {
    val issuer = this
    stage.addEventHandler(FXWindowEvent.ANY, new EventHandler[FXWindowEvent] {
      override def handle(event: FXWindowEvent): Unit = {
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
