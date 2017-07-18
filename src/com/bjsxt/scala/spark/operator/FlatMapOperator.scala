package com.bjsxt.scala.spark.operator

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/6/7.
  */
object FlatMapOperator {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("FlatMapOperator").setMaster("local")
    val sc = new SparkContext(conf)

    val lineArray = Array("hello xuruyun", "hello xuruyun", "hello wangfei")



    val testArray = Array(Array("aaa","bbb"),Array("ccc","ddd"),Array("eee","fff"))

    val flatten = testArray.flatten
    println("222222")
    flatten.foreach(println)
    println("333333")

    val linesRDD = sc.parallelize(lineArray)
    // {hello,xuruyun,hello,xuruyun,hello,wangfei}

    /**
      * hello
      * xuruyun
      * hello
      * xuruyun
      * hello
      * wangfei
      */
    //    val wordsWithFlatMap = linesRDD.flatMap(_.split(" "))


    /**
      * [Ljava.lang.String;@7134ead0
      * [Ljava.lang.String;@492437c0
      * [Ljava.lang.String;@68c843c3
      */
    val wordsWithMap = linesRDD.map(_.split(" "))


    //
    //
    //     wordsWithFlatMap.foreach(println _)


    wordsWithMap.foreach(println _)


    /* val wordsWithMapResult = wordsWithMap.collect()
     for(a<- wordsWithMapResult){
       println(a.length)
     }*/
  }
}
