import java.text.DecimalFormat

class CheckoutItems {
  def checkoutItems(d: Double) = {
    val decimalFormat = new DecimalFormat("0.00")
    s"""£${decimalFormat.format(d)}"""
  }

  def scanItems(items: Map[String, Int]) = {

    items.foldLeft(0.0){ case (total, (item, quantity)) =>
      val result =  item match {
          case "Apple" =>
            val res  = (quantity / 2) + (quantity % 2)
            total + ((0.6) * res)
          case "Orange" =>
           val res =  (quantity / 3) * (0.5) + ((quantity % 3) * 0.25)
            total + res
        }

      BigDecimal(result).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
  }

}
