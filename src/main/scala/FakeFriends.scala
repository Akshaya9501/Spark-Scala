import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
object FakeFriends {

 private case class Person(ID: Int, name: String, age: Int, count: Int)

  def mapper(lines: String): Person = {
    val fields = lines.split(',')
    val person: Person = Person(fields(0).toInt, fields(1), fields(2).toInt, fields(3).toInt)
     person
  }
private def sparkSession: SparkSession ={
  SparkSession
    .builder
    .appName("FakeFriends")
    .master("local")
    .config("spark.sql.warehouse.dir", "file:///C:/tmp")
    .getOrCreate()

}
  def main(args:Array[String])
  {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark=sparkSession
    import spark.implicits._
    val lines = spark.sparkContext.textFile("src/main/resources/fakefriends.csv")
    val people = lines.map(mapper).toDS().cache()

    people.printSchema()
    people.createOrReplaceTempView("people")
    people.select("name").show()
    people.filter(people("age")<40).show()
    people.select("count").count
    people.groupBy("count").min().show()
    people.select(people("age")+10).show()
    val result = spark.sql("Select * from people where age<40")
    val dataVal=result.collect()
    dataVal.foreach(println)
    spark.stop()
  }
}
