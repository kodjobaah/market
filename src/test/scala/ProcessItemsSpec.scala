import org.scalatest._

import org.scalatest.OptionValues._

class ProcessItemsSpec extends FlatSpec with Matchers {

  val processItems = new ProcessItems
  "readItems" should "return a map of items and their counts" in {

    val items = Seq("Apple", "Apple", "Apple", "Orange", "Apple")
    val result = processItems.readItems(items)

    result.get("Apple").value should be(4)
    result.get("Orange").value should be(1)
  }

  it should "filter out items that we can not process" in {

    val items = Seq("Apple", "Apple", "Apple", "Sugar", "Orange", "Apple")
    val result = processItems.readItems(items)

    result.get("Apple").value should be(4)
    result.get("Orange").value should be(1)

  }

  it should "empty items if list does not contain apple or orange" in {

    val items = Seq("Sugar")
    val result = processItems.readItems(items)

   result should have size(0)
  }
}
