package common

import word_count.args_check

class args_checkSpec extends FutureXBase {

  behavior of "Test if args are properly parsed"
  it should("Test if args.topRank is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.topRank   == (5))
  }

  it should("Test if args.specificWord is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.specificWord == "")
  }

  it should("Test if args.inCSVpath is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.inCSVpath    == "src/main/resources/in/table.csv")
  }

  it should("Test if args.inCSVschema is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.inCSVschema  == "src/main/resources/in/schema.csv")
  }

  it should("Test if args.appName is properly parsed") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.appName      == "WordCount")
  }

  it should("Test if args.csvDelimiter is properly identified") in {
    val args: Array[String] = Array("-r","5")
    val params  = args_check.configRead(args)
    assert(params.csvDelimiter == ",")
  }

//  it should("Test if args are properly parsed") in {
//    val args: Array[String] = Array("-r","5")
//    val params  = args_check.configRead(args)
//
//    assert(params.topRank   == (5))
//    assert(params.specificWord == "")
//    assert(params.inCSVpath    == "src/main/resources/in/table.csv")
//    assert(params.inCSVschema  == "src/main/resources/in/schema.csv")
//    assert(params.appName      == "WordCount")
//    assert(params.csvDelimiter == ",")
//  }





}
