object Day21ReadingJSONwithUPickle extends App {
  val src = "src/resources/json/fruitFacts.json"

  val rawText = Util.getTextFromFile(src)
  println(rawText.take(100))

  //let's use uPickle library to parse the raw Text into some structure
  val data = ujson.read(rawText)
  println(data)

  //in order for arr method to work I need to know that my top level of data is actually an array (not an object or just a string or number)
  val arrData = data.arr.toArray
  println(arrData.head)
  println(arrData.last)
  //with o I indicate that it is an object
  val fruits = for (o <- arrData) yield {
    Fruit(o("genus").str,
      o("name").str,
      o("id").num.toInt,
      o("family").str,
      o("order").str,
      o("nutritions")("carbohydrates").num.toDouble, //so Double by default
      o("nutritions")("sugar").num.toDouble,
      o("nutritions")("protein").num.toDouble,
      o("nutritions")("fat").num,
      o("nutritions")("calories").num
      //TODO add the rest of the fields proteins etc
    )
  }

  val highCalFruits =  fruits.sortBy(_.calories)

  println(s"The highest calories per 100g is ${highCalFruits.reverse.head} ")
  //TODO find top 5 fattiest fruits
  val topFatFruits =  fruits.sortBy(_.fat)
  println(s"The highest fat content per 100g: ")
  topFatFruits.reverse.take(5).foreach(println)
  //TODO find top 5 protein sources for fruits
  val topProteinFruits =  fruits.sortBy(_.protein)
  println(s"The highest protein content per 100g: ")
  topProteinFruits.reverse.take(5).foreach(println)
  //TODO find 5 least sugary fruits
  val MinSugarFruits =  fruits.sortBy(_.sugar)
  println(s"The lowest sugar  content per 100g: ")
  MinSugarFruits.take(5).foreach(println)

  //TODO find 5 fruits with most carbohydrates that are not sugars (so difference between carbohydrates and sugar)

  val NonSugarCarbs=fruits.sortBy(_.nonsugarcarbs)
  println(s"The highest non sugar carbohydrates per 100g: ")
  NonSugarCarbs.take(5).foreach(println)
}

  //TODO find most calorie dense fruit - it looks the data is per 100grams maybe someone can verify this?
  //TODO find top 5 fattiest fruits
  //TODO find top 5 protein sources for fruits
  //TODO find 5 least sugary fruits
  //TODO find 5 fruits with most carbohydrates that are not sugars (so difference between carbohydrates and sugar)

  //you can add some extra conclusions, statistics as well
