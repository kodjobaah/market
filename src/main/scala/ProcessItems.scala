/**
 * Created by kodjobaah on 19/04/2017.
 */
class ProcessItems {

  def readItems(items: Seq[String]): Map[String, Int] = {
    items.groupBy(identity).mapValues(_.size)
  }
}
