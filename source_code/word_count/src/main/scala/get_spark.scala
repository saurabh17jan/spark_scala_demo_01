package word_count

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger

object get_spark {

  def start_spark(log:Logger,appName:String="ApplicationName"):(SparkContext,SparkSession)   ={


    val sparkConf = new SparkConf()
      .setAppName(appName)
      .setMaster("local[3]")

//    val sc = new SparkContext(sparkConf)
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    val sc = spark.sparkContext

    println( "---------------------------------------------------------------------------------------------------------------------------------------------")
    log.warn(" Yarn application id is: " + spark.sparkContext.applicationId)
    println( " Yarn application id for ('"+ spark.sparkContext.appName +"') is: " + spark.sparkContext.applicationId)
    println( "---------------------------------------------------------------------------------------------------------------------------------------------")

    (sc,spark)

  }

}
