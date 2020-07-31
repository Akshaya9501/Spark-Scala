import net.sf.cglib.core.Local
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object WordCount {

  private def rddCreation(filePath: String): RDD[(Int, String)] = {
    val sc = new SparkContext("local", "WordCount")
    val rdd = sc.textFile(filePath)
    val wordMap = rdd.flatMap(x => x.split("\\W+"))
    val lowerCaseWords = wordMap.map(x => x.toLowerCase())
    val wordCounts = lowerCaseWords.map(x => (x, 1)).reduceByKey((x, y) => x + y)
    wordCounts.map(x => (x._2, x._1)).sortByKey()

  }

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sortedWords = rddCreation("src/main/resources/book.txt")

    for (word <- sortedWords) {
      val count = word._1
      val words = word._2
      println(s"$words: $count ")
    }
  }
}
