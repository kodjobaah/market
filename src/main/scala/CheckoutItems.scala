import java.text.DecimalFormat


object CheckoutItems {

  val ApplePrice = 0.6
  val OrangePrice = 0.25
  val Apple = "Apple"
  val Orange = "Orange"
}
class CheckoutItems {

  import CheckoutItems._

  def checkoutItems(d: Double) = {
    val decimalFormat = new DecimalFormat("0.00")
    s"""£${decimalFormat.format(d)}"""
  }

  def scanItems(items: Map[String, Int]) = {

    def calculateOffer(itemPrice: Double, itemCount: Int, offerAmount: Int, quantity: Int): Double = {
      itemPrice * (((quantity / offerAmount) * itemCount) + ((quantity % offerAmount)))
    }

    items.foldLeft(0.0){ case (total, (item, quantity)) =>
      val result =  total + (item match {
          case Apple =>
            calculateOffer(ApplePrice, 1, 2, quantity)
          case Orange =>
            calculateOffer(OrangePrice, 2, 3, quantity)
        })

      BigDecimal(result).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

  }

}
