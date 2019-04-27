package Enum

/**
  * Exhibits the behavior of Enumeration superclass
  */
object Demo extends App{

  object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }
  import WeekDay._ //can throw relative imports where needed

  def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

  //printing WeekDay values
  println(WeekDay.values) //returns a ValueSet

  WeekDay.values filter isWorkingDay foreach println //syntactic sugar

  for(day <- WeekDay.values){
    println(day.id + " " + day)
  }
}
