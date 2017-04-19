import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kodjobaah on 19/04/2017.
 */
class CheckoutSpec extends FlatSpec with Matchers with MockFactory {

  "checkoutItems" should "checkout the items" in {

    val processItems = mock[ProcessItems]
    val checkoutItems = mock[CheckoutItems]

    val checkout = new Checkout(processItems, checkoutItems)
    val input = Seq("Apple")
    val output = Map("Apple" -> 1)
    val cost = 0.6
    val totalCost = "£0.6"
    inSequence {

      (processItems.readItems _).expects(input).returns(output)
      (checkoutItems.scanItems _).expects(output).returns(cost)
      (checkoutItems.checkoutItems _).expects(cost).returns(totalCost)
    }

    val result = checkout.checkoutItems(input)
    result should be(totalCost)
  }
}
