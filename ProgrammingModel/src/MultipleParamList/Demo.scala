package MultipleParamList

/**
  * Demonstrates a functional programming aspect of scala: multiple parameter lists
  * They let you have both implicit and non-implicit parameters
  * They facilitate type inference
  * A parameter in one group can use a parameter from a previous group as a default value
  */
object Demo extends App{

  //example 1 currying
  def sum(a: Int)(b: Int)(c: Int) = a + b + c
  println(sum(1)(2)(3)) //6

  //example 2 currying multiple length parameter length
  def doFoo(firstName: String, lastName: String)(age: Int): String =
    firstName + " " + lastName + ": " + age

  println(doFoo("Cameron", "Zurmuhl")(20)) //Cameron Zurmuhl: 20


  //example 3: defining your own control structure

  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit ={ //: => is a by name parameter so it will only execute when evaluated in the function
    while(testCondition){
      codeBlock
    }
  }

  //using whilst

  var i = 1
  whilst(i < 5){
    println(i)
    i +=1
  } //prints 1 to 4, inclusive


  //example 4 using implicit values

  def printIntIfTrue(a: Int)(implicit b: Boolean) = if (b) println(a)

  //defining an implicit boolean value
  implicit val boo = true

  printIntIfTrue(33) //since there is an implicit value in scope, boo is used. 33 is printed
}
