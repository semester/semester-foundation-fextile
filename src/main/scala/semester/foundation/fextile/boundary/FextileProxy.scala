package semester.foundation.fextile.boundary

import semester.foundation.fextile.application.{ApplicationHelper, Fextile}

case class FextileProxy[D](delegate: FextileDelegate[D])
                           (operation: D => Unit) {
  implicit val executor = ApplicationHelper.fxExecutionContext

  def enqueue(): Unit = {
    Fextile.ref ! this
  }

  def execute(): Unit = {
    delegate.delegate.map {
      d =>
        operation(d)
    }
  }
}
