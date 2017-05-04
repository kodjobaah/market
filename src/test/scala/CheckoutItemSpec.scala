import org.scalatest.{FlatSpec, Matchers}


class CheckoutItemSpec extends FlatSpec with Matchers {

  val checkoutItems = new CheckoutItems
  "scanItems" should "return the cost if only apples" in {

    val items = Map("Apple" -> 3)
    val result = checkoutItems.scanItems(items)

    result should be(1.20)

  }

  it should "return the cost if only orange" in {

    val items = Map( "Orange" -> 1)
    val result = checkoutItems.scanItems(items)

    result should be(0.25)

  }

  it should "return the cost of apples and oranges" in {

    val items = Map("Apple" -> 3, "Orange" -> 1)
    val result = checkoutItems.scanItems(items)

    result should be(1.45)

  }

  it should "return the cost of 3 oranges" in {

    val items = Map("Orange" -> 3)
    val result = checkoutItems.scanItems(items)

    result should be(0.50)

  }

  it should "return the cost of 4 oranges" in {

    val items = Map("Orange" -> 4)
    val result = checkoutItems.scanItems(items)

    result should be(0.75)

  }

  "checkoutItems" should "add a pound sign to the output" in {

    val result = checkoutItems.checkoutItems(0.30)
    result should be("£0.30")
  }
}
