package semester.foundation.fextile.boundary

import semester.foundation.fextile.application.ApplicationHelper
import semester.foundation.fextile.event.EventSource

import scala.concurrent.Future

trait FextileDelegate[+D]
  extends EventSource {

  implicit val executor = ApplicationHelper.fxExecutionContext

  val delegate: Future[D] = Future {
    val d = createDelegate
    decorateDelegate(d)
    d
  }

  def delegate[R](operation: D => R): Future[R] = {
    delegate.map(operation)
  }
  
  protected def createDelegate: D
  
  protected def decorateDelegate[DD >: D](target: DD): Unit = {}
}
