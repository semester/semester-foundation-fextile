package semester.foundation.fextile.stage

import javafx.{stage => fxs}

import semester.foundation.fextile.boundary.FextileDelegate

import scala.concurrent.Future

class Stage
  extends Window
  with FextileDelegate[fxs.Stage] {

  override def createDelegate: fxs.Stage = new fxs.Stage()

  def title: Future[String] = delegate(_.getTitle)

  def title_=(t: String): Unit = delegate(_.setTitle(t))
}
