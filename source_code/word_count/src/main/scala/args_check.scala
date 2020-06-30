package  word_count

object args_check {
  /**
   * A case class to hold and reference our command line args:
   */
  case class CommandLineArgs(
                                topRank       : Int     = 3
                              , specificWord  : String  = "" // default is ""
                              , inCSVpath     : String  = "src/main/resources/in/table.csv"
                              , inCSVschema   : String  = "src/main/resources/in/schema.csv"
                              , appName       : String  = "WordCount"
                              , csvDelimiter  : String  = ","
                            )


  def configRead(args: Array[String]) = {


    val parser = new scopt.OptionParser[CommandLineArgs]("spark-word-count") {
      head("spark-word-count", "1.0")
      opt[Int    ]('r', "topRank"      ).required().valueName("<topRank>").action((x, c)  => c.copy(topRank      = x)).text("topRank  is required")
      opt[String ]('w', "specificWord" ).action((x, c)                                    => c.copy(specificWord = x)).text("specificWord is a word whose count we want to find ")
      opt[String ]('p', "inCSVpath"    ).action((x, c)                                    => c.copy(inCSVpath    = x)).text("inCSVpath, is the location for input/source file")
      opt[String ]('s', "inCSVschema"  ).action((x, c)                                    => c.copy(inCSVschema  = x)).text("inCSVschema, is the location for input/source file")


      /**
       * this will print all the message if '--help' is passed via cli
       */
      help("help").text("Prints details about expected args to execute jar")

      /**
       * this will display Usage in case the args parse fails
       * like when data-type mismatch happens then it will show --help
       */
      override def showUsageOnError = true

      /**
       * if there's an unknown arg passed
       * set
       *     ( 'showUsageOnError' = true
       *       'errorOnUnknownArgument' = true)
       *     => display the --help details
       *
       */
      override def errorOnUnknownArgument = true

    }

    /**
     * use this so that you can return the details back to
     * calling function
     */
    parser.parse(args, CommandLineArgs()).getOrElse(CommandLineArgs())


  }


}
