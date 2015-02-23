package semester.foundation.fextile.scene

import javafx.{scene => fxs}

import semester.foundation.fextile.boundary.FextileDelegate

import scala.concurrent.Future

abstract class Scene extends FextileDelegate[fxs.Scene] {
  override val delegate: Future[fxs.Scene] = Future {
    new fxs.Scene(new fxs.Group())
  }
}
