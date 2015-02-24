package semester.foundation.fextile.scene

import javafx.{scene => fxs, scene}

import semester.foundation.fextile.boundary.FextileDelegate

class Scene extends FextileDelegate[fxs.Scene] {
  override protected def createDelegate: scene.Scene = {
    new fxs.Scene(new fxs.Group())
  }

  override protected def decorateDelegate[DD >: scene.Scene](target: DD): Unit = {
    super.decorateDelegate(target)
    target match {
      case scene: fxs.Scene =>

    }
  }
}
