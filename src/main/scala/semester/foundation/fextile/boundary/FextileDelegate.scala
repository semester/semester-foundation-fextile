package semester.foundation.fextile.boundary

import semester.foundation.fextile.application.ApplicationHelper
import semester.foundation.fextile.event.EventSource

import scala.concurrent.Future

trait FextileDelegate[D]
  extends EventSource {

  implicit val executor = ApplicationHelper.fxExecutionContext

  val delegate: Future[D]

  def delegate[R](operation: D => R): Future[R] = {
    delegate.map(operation)
  }

  def decorate(target: D)
              (operation: D => Unit): D = {
    operation(target)
    target
  }

}
