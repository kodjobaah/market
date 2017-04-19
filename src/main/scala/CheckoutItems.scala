import java.text.DecimalFormat

/**
 * Created by kodjobaah on 19/04/2017.
 */
class CheckoutItems {
  def checkoutItems(d: Double) = {
    val decimalFormat = new DecimalFormat("0.00")
    s"""£${decimalFormat.format(d)}"""
  }

  def scanItems(items: Map[String, Int]) = {

    items.foldLeft(0.0){ case (total, (item, quantity)) =>
      val result =  item match {
          case "Apple" => total + (0.6) * quantity
          case "Orange" => total + (0.25) * quantity
        }

      BigDecimal(result).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
  }

}
