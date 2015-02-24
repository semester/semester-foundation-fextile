# Fextile, Akka + JavaFX Proof of Concept

Since GUI framework like JavaFX requires always run on main thread for handle events/manipurating UI properties. This usually cause unexpected behaviors. Fextile trying to separate layout specific codes, handling events, manipurating UI properties, and business logic on top of Akka async messaging framework.

## Example

Defining layout is very similar to JavaFX/ScalaFX applications.

```scala
object MyApp extends FextileApp {
  // Do layout just like JavaFX/ScalaFX application
  stage = new PrimaryStage {
    title = "My Application"
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.BLUE
    }
  }

  override def props: Option[Props] = Some(Props[MyApp])
}
```

For all events from scene graph are transfered to actors on Akka.

```scala
class MyApp extends Actor {
  override def receive: Receive = {
    case (s: Scene, e: MouseClicked) =>
      s.fill = Color.RED

    case (_, _: WindowHidden) =>
      Fextile.shutdown()
  }
}
```

# Requirements

* JDK 8
* Scala 2.11

# License

Unless otherwise noted, all files in this distribution are released under the MIT License.
Exceptions are noted within the associated source files.

----

The MIT License (MIT) Copyright (c) 2015 Takayuki Okazaki

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
