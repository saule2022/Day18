case class Fruit(genus:String,
                 name:String,
                 id:Int,
                 family:String,
                 order:String,
                // i am flattening the nutrition
                 carbohydrates:Double=0.0,
                 sugar:Double=0.0,
                 protein:Double=0.0,
                 fat:Double=0.0,
                 calories:Double=0.0
                 ) {
  val nonsugarcarbs= carbohydrates-sugar

}

//Todo add the rest of fields from nutrition