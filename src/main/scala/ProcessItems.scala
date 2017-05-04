
class ProcessItems {

  def readItems(items: Seq[String]): Map[String, Int] = {
    items.groupBy(identity).mapValues(_.size)
  }
}
