package semester.foundation.fextile.scene

import javafx.scene.{Parent => FXParent}

import semester.foundation.fextile.boundary.FextileDelegate

import scala.concurrent.Future

class Parent extends FextileDelegate[FXParent] {
  override val delegate: Future[FXParent] = _
}
