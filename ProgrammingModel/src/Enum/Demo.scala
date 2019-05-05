package Enum

/**
  * Exhibits the behavior of Enumeration class
  */
object Demo extends App{

  object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }
  import WeekDay._ //can throw relative imports where needed in Scala

  def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

  //printing WeekDay values
  println(WeekDay.values) //returns WeekDay.ValueSet(Mon, Tue, Wed, Thu, Fri, Sat, Sun)

  WeekDay.values filter isWorkingDay foreach println //syntactic sugar, prints Mon-Fri on separate lines


  for(day <- WeekDay.values){
    println(day.id + " " + day)
  }

    /*
    output: 0 Mon
    1 Tue
    2 Wed
    3 Thu
    4 Fri
    5 Sat
    6 Sun
     */
}
