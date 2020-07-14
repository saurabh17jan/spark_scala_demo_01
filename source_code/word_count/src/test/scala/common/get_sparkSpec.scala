package common
//package word_count


import org.apache.log4j.Logger
import word_count.get_spark

class get_sparkSpec extends FutureXBase {

  behavior of "Checking if the sparkSession and SparkContect gets created in get_spark"
  it should("Checking if SparkContext and SparkSession is getting created")
  val log = Logger.getLogger("word_count")
  val (sc, spark)  = get_spark.start_spark(log)

}
