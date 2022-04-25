object Day20CSVExcercise extends App{

  val src = "src/resources/csv/fruitvegprices-19apr22.csv" //TODO list .csv files in folder

  val lines = Util.getLinesFromFile(src)
  val splitLines = lines.map(_.split(","))
  def arrayToVeggie(arr:Array[String]):Veggie = {

    Veggie(arr(0), arr(1), arr(2), arr(3),arr(4).toDouble, arr(5))
  }

  val lastItem = arrayToVeggie(splitLines.last)

  val veggies = splitLines.tail.map(arrayToVeggie)

  val prices = veggies.map(_.price)

  val variety=veggies.map(_.variety)


  //TODO get the top 5 most expensive apple entries
  //TODO get the least expensive 5 apple entries
  val apples = veggies.filter(_.item == "apples").sortBy(_.price)

  println("The most expensive apples:")
  apples.reverse.take(5).foreach(println)

  println("The least expensive apples:")
  apples.take(5).foreach(println)
  //TODO get average price for lettuce

  val lettuce = veggies.filter(_.item == "lettuce")
  val averLettprice=lettuce.map(_.price).sum/lettuce.map(_.price).length
  println("Average lettuce price:")
  val averLettuce=Util.myRound(averLettprice,2)
  println(averLettuce)
  //TODO get cherry tomatoes pricing min, max, mean for year 2022
  val MinCherTomatoes = veggies.filter(_.item == "tomatoes").filter(_.variety == "cherry").filter(_.date.contains("2021")).sortBy(_.price).take(1).mkString
  val MaxCherTomatoes = veggies.filter(_.item == "tomatoes").filter(_.variety == "cherry").filter(_.date.contains("2021")).sortBy(_.price).reverse.take(1).mkString

  println("Cherry Tomatoes pricing:")
  println(s"Min price: $MinCherTomatoes")
  println(s"Maxn price: $MaxCherTomatoes")

  val CherTomatoes = veggies.filter(_.item == "tomatoes").filter(_.variety == "cherry").filter(_.date.contains("2021"))

  val avertomatoes=Util.myRound(CherTomatoes.map(_.price).sum/CherTomatoes.map(_.price).length,2)
  println(s"Mean price for 2021 year: $avertomatoes")

  //TODO extra credit challenge get average price for lettuce by year

  val lettuce2022 = veggies.filter(_.item == "lettuce").filter(_.date=="2022")
  val averLettprice2022=lettuce2022.map(_.price).sum/lettuce2022.map(_.price).length
  println("Average 2022 year lettuce price:")
  val averLettuce2022=Util.myRound(averLettprice2022,2)
  println(averLettuce2022)

  val lettuce2021 = veggies.filter(_.item == "lettuce").filter(_.date.contains ("2021"))
  val averLettprice2021=lettuce2021.map(_.price).sum/lettuce2021.map(_.price).length
  println("Average 2021 year lettuce price:")
  val averLettuce2021=Util.myRound(averLettprice2021,2)
  println(averLettuce2021)


  val lettuce2019 = lettuce.filter(_.date.contains ("2019")).map(_.price)
  val averLettprice2019=lettuce2019.sum/lettuce2019.length
  println("Average 2019 year lettuce price:")
  val averLettuce2019=Util.myRound(averLettprice2019,2)
  println(averLettuce2019)


  //two approaches - one is simply hardcode starting and ending years and filter by those
  //you might not even need to extract year simply lexicographical filering should work

  //even better approach use groupBy
  // hint: use groupBy but first you would need to modify case class with Year field(value)
  //alternative to creating a Year entry would be to split date field while grouping and group by first portion
  // https://alvinalexander.com/scala/how-to-split-sequences-subsets-groupby-partition-scala-cookbook/
}