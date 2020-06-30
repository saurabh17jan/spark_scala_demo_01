package word_count

import org.apache.log4j.Logger

object perform_transformation {

  def getGoing(params: args_check.CommandLineArgs, log: Logger): Unit ={

    /**
     * Initialising SparkSession
     */
    log.warn(" Initialising SparkSession ! ")
    val (sc, spark) = get_spark.start_spark(log, params.appName)

    log.info(" Start processing as a dataframe !")
    df_transformation.startProcessing(spark,params)

    log.info(" Start processing as RDD !")
    rdd_transformation.startProcessing(sc, params)



  }

}
