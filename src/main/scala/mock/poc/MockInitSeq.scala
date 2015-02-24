package mock.poc

object MockInitSeq {
  trait GrandParent {
    def name: String = "GrandParent"
  }
  trait Parent1 extends GrandParent {
    override def name: String = "Parent1"
  }
  trait Parent2 extends GrandParent {
    override def name: String = "Parent2"
  }
  class Child extends Parent1 with Parent2 {
    def myParent() = {
      println(s"${super.name}")
    }
  }

  def main(args: Array[String]) {
    val child = new Child()
    println(s"${child.name}")
  }
}
