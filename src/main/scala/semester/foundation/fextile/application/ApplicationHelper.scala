package semester.foundation.fextile.application

import java.util.concurrent.{Executor, Semaphore}
import javafx.application.{Application => JavaFXApplication, Platform}
import javafx.stage.{Stage => JavaFXStage}

import scala.concurrent.{ExecutionContext, Future}

private[fextile]
class ApplicationHelper
  extends JavaFXApplication {

  def start(stage: JavaFXStage): Unit = {
    ApplicationHelper.stage = Some(stage)
    ApplicationHelper.launchLock.release(Integer.MAX_VALUE)
    ApplicationHelper.launcher.foreach {
      launcher =>
        stage.show()
    }
  }
}

object ApplicationHelper {
  private[fextile] var launcher: Option[ApplicationLauncher] = None
  private[fextile] var stage: Option[JavaFXStage] = None
  private[fextile] val launchLock: Semaphore = {
    val semaphore = new Semaphore(Integer.MAX_VALUE)
    semaphore.drainPermits()
    semaphore
  }

  def fxExecutionContext: ExecutionContext = {
    ExecutionContext.fromExecutor(
      new Executor {
        override def execute(command: Runnable): Unit = {
          Future {
            if (ApplicationHelper.launchLock.availablePermits() < 1) {
              ApplicationHelper.launchLock.acquire()
            }
            Platform.runLater(command)
          }(Fextile.system.dispatcher)
        }
      }
    )
  }

}
