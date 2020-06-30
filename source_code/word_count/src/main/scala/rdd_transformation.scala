package word_count
import org.apache.spark.SparkContext

object rdd_transformation {

  def startProcessing(sc :SparkContext, params: args_check.CommandLineArgs): Unit ={

    /**
     * read csv file using SparkContext
     * Apply some transformation to get the word count
     * if SpecificWord is passed then apply logic to display only the details of it
     * else
     * display top n words and their count
     */
    val lines = sc.textFile(params.inCSVpath)
    val wordRdd = lines.flatMap(line => line.split(params.csvDelimiter))

    val wordPairRdd = wordRdd.map(word => (word, 1))

    val wordCounts = wordPairRdd.reduceByKey((x, y) => x + y)

    val sortedWordCounts = wordCounts.sortBy(wordCount => wordCount._2, ascending = false).collect()

    if(params.specificWord.isEmpty){
      for ((word, count) <- sortedWordCounts.take(params.topRank)) println(if(word.isEmpty) "Null"+":"+count else word +":"+count)
    }
    else{
      for ((word, count) <- sortedWordCounts.filter(_._1==params.specificWord))  println(word +":"+count)
    }

  }
}
