package MultipleParamList

/**
  * Demonstrates a functional programming aspect of scala: multiple parameter lists
  * They let you have both implicit and non-implicit parameters
  * They facilitate type inference
  * A parameter in one group can use a parameter from a previous group as a default value
  */
object Demo extends App{

  //example 1
  def sum(a: Int)(b: Int)(c: Int) = a + b + c
  println(sum(1)(2)(3))

  //example 2
  def doFoo(firstName: String, lastName: String)(age: Int): String =
    firstName + " " + lastName + ": " + age

  println(doFoo("Cameron", "Zurmuhl")(20))


  //example 3: defining your own control structure

  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit ={
    while(testCondition){
      codeBlock
    }
  }

  //using whilst

  var i = 1
  whilst(i < 5){
    println(i)
    i +=1
  }


  //example 4 using implicit values

  def printIntIfTrue(a: Int)(implicit b: Boolean) = if (b) println(a)

  //defining an implicit boolean value
  implicit val boo = true

  printIntIfTrue(33) //since there is an implicit value in scope, boo is used
}
