package word_count
import org.apache.spark.sql.functions.{col,asc,desc}
import org.apache.spark.sql.types.{DateType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession
object df_transformation {

  def startProcessing(spark : SparkSession, params: args_check.CommandLineArgs): Unit ={
    val customSchema = StructType(Array(
      StructField("EMPNO"     , IntegerType , true),
      StructField("ENAME"     , StringType  , true),
      StructField("JOB"       , StringType  , true),
      StructField("MGR"       , StringType  , true),
      StructField("HIREDATE"  , DateType    , true),
      StructField("SAL"       , IntegerType , true),
      StructField("COMM"      , IntegerType , true),
      StructField("DEPTNO"    , IntegerType , true)
    )
    )

    val df = spark.read
      .format("csv")
      .option("header", "true")
      .option("dateFormat","dd-mm-yyyy")
      .option("mode","DROPMALFORMED")
      .option("treatEmptyValuesAsNulls", "true")
      .schema(customSchema)
      .load(params.inCSVpath)

    df.show(100, false)
    df.printSchema()

    df.groupBy(col("job"),col("HIREDATE"))
      .sum("sal")
      .orderBy(asc("job"), desc("sum(sal)"))
      .show()

  }
}
