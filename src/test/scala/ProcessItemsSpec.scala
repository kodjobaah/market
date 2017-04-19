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
}
