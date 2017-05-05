
class ProcessItems {


  def readItems(items: Seq[String]): Map[String, Int] = {
    val allowableItems = List(CheckoutItems.Apple, CheckoutItems.Orange)
    items.filter(allowableItems.contains(_)).groupBy(identity).mapValues(_.size)
  }
}
