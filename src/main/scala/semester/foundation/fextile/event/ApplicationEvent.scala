package semester.foundation.fextile.event

import semester.foundation.fextile.application.FextileApp

trait ApplicationEvent
  extends Event[FextileApp]

case class ApplicationWillLaunch(issuer: FextileApp,
                                 args: Array[String])
  extends ApplicationEvent
