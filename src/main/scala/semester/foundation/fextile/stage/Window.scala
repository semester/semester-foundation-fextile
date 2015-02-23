package semester.foundation.fextile.stage

import javafx.{stage => fxs}

import semester.foundation.fextile.boundary.FextileDelegate

import scala.concurrent.Future

abstract class Window extends FextileDelegate[fxs.Window] {
  override val delegate: Future[fxs.Window] = Future {
    new fxs.Stage()
  }

  //----
  // Read only properties

  def focused: Future[Boolean] = delegate(_.isFocused)

  def showing: Future[Boolean] = delegate(_.isShowing)

  //----
  // Read/Write Properties

  def width: Future[Double] = delegate(_.getWidth)

  def width_=(w: Double): Unit = delegate(_.setWidth(w))

  def height: Future[Double] = delegate(_.getHeight)

  def height_=(h: Double): Unit = delegate(_.setHeight(h))

  def x: Future[Double] = delegate(_.getX)

  def x_=(v: Double) = delegate(_.setX(v))

  def y: Future[Double] = delegate(_.getY)

  def y_=(v: Double) = delegate(_.setY(v))

  def opacity: Future[Double] = delegate(_.getOpacity)

  def opacity_=(o: Double) = delegate(_.setOpacity(o))

  //----
  // Operations

  def centerOnScreen() = delegate(_.centerOnScreen())

  def hide() = delegate(_.hide())

  def requestFocus() = delegate(_.requestFocus())

  def sizeToScene() = delegate(_.sizeToScene())
}
