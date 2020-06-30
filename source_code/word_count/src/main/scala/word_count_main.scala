package word_count

import org.apache.log4j.Logger

object word_count_main {

  val log = Logger.getLogger("word_count")

  def main(args: Array[String]): Unit = {


    log.info(" Parse CLI args ! ")
    val params = args_check.configRead(args)

    log.info(" Start transformation ! ")
    perform_transformation.getGoing(params,log)

  }
}
