/**
 * Created by kodjobaah on 19/04/2017.
 */
class Checkout(processItems: ProcessItems, checkout: CheckoutItems) {

  def checkoutItems(items: Seq[String]) = {
    val itemsToCheckout = processItems.readItems(items)
    val cost = checkout.scanItems(itemsToCheckout)
    checkout.checkoutItems(cost)
  }
}
