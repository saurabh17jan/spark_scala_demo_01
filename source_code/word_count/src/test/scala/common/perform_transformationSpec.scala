package common

import org.apache.log4j.Logger
import word_count.{args_check, get_spark, perform_transformation}

class perform_transformationSpec extends FutureXBase {
  behavior of "Checking if the sparkSession and SparkContect gets created in get_spark"
  it should("Checking if SparkContext and SparkSession is getting created")
  val log = Logger.getLogger("word_count")
  val (sc, spark)  = get_spark.start_spark(log)
  val args: Array[String] = Array("-r","5")
  val params  = args_check.configRead(args)
  perform_transformation.getGoing(params,log)

}
