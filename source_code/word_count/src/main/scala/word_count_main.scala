package word_count

import org.apache.log4j.Logger

object word_count_main {

  val log = Logger.getLogger("word_count")

  def main(args: Array[String]): Unit = {


    log.warn(" Parsing CLI args ! ")
    val params = args_check.configRead(args)

    val transform_df = perform_transformation.getGoing(params,log)

//    val trdf = get_spark.main(args)
  }
}
