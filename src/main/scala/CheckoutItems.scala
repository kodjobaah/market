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

    items.foldLeft(0.0){ case (total, (item, quantity)) =>
      val result =  item match {
          case Apple =>
            val res  = (quantity / 2) + (quantity % 2)
            total + ((ApplePrice) * res)
          case Orange =>
           val res =  (quantity / 3) * (OrangePrice * 2) + ((quantity % 3) * OrangePrice)
            total + res
        }

      BigDecimal(result).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

  }

}
