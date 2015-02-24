package mock.poc

object MockInitSeq {

  class DataParent {
    val name = "parent"

    var status: String = "initial"

    override def toString: String = s"name: $name, status; $status"
  }
  class DataChild extends DataParent {
    override val name: String = "child"

    var childStatus: String = "initial"

    override def toString: String = s"name: $name, status; $status, child: $childStatus"
  }

  trait Base[+A] {
    val value: A = {
      val a = create
      decorate(a)
      a
    }

    def create: A

    def decorate[B >: A](d: B): Unit = {}
  }

  class OperationParent extends Base[DataParent] {
    override def create: DataParent = new DataParent

    override def decorate[B >: DataParent](d: B): Unit = {
      println("decorate on OperationParent")
      d match {
        case dp: DataParent =>
          dp.status = "decorated:parent"
      }
    }
  }

  class OperationChild extends OperationParent with Base[DataChild] {
    override def create: DataChild = new DataChild

    override def decorate[B >: DataChild](d: B): Unit = {
      println("decorate on OperationChild")
      super.decorate(d)
      d match {
        case dc: DataChild =>
          dc.childStatus = "decorated:child"
      }
    }
  }

  def main(args: Array[String]) {
    val op = new OperationParent
    val oc = new OperationChild
    println(s"${new DataChild}")
    println(s"op: ${op.value}")
    println(s"oc: ${oc.value}")
  }
}
