package common

import org.apache.log4j.Logger
import org.scalatest.Ignore
import word_count.{args_check, df_transformation, get_spark, perform_transformation}

//@Ignore
class df_transformationSpec extends FutureXBase {
  //  def startProcessing(spark : SparkSession, params: args_check.CommandLineArgs) {
  //  perform_transformation.getGoing(params,log)


  behavior of "Checking if the sparkSession and SparkContect gets created in get_spark"
  it should("Checking if SparkContext and SparkSession is getting created")
  val log = Logger.getLogger("word_count")
  val (sc, spark)  = get_spark.start_spark(log)
  val args: Array[String] = Array("-r","5")
  val params  = args_check.configRead(args)
  val df = df_transformation.startProcessing(spark , params)
  assert(df.count() == 14)

/*
  behavior of "Test if args are properly parsed"
  it should("Test if args.topRank is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.topRank   == (5))
  }
  */
}
