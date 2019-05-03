package Visibility

/**
  * Demo demonstrates examples with getters and setters in scala
  */
object Demo extends App {

  class Person(var name:String, var age:Int){
    require(age > 0) //throws exception if requirement not met
  }
  class Alien(val name:String, val age:Int)
  class Bruce(name:String)

  var me = new Person("Cameron", 20)
  //var bad = new Person(name = "who", age = -9) This would throw and error
  var other = new Alien("Xenomorph", age = 100)
  val Brucy = new Bruce(name = "Bruce")

  //demonstrating getter
  println("var has a getter: " + me.name)
  println("val has a getter: " + other.name)
  println("Bruce does not have a getter.")

  //demonstrating setter
  me.age = 21
  println("var can be set: " + me.age)
  println("cannot set anything in Bruce class, that class's args are treated as val.")

  println("Note if any constructor args are private, can't do any setters or getters")
  //since the constructor args with no visibility modifiers are not stored as members
}

/**
  * Demo2 demonstrates a Bank Account class
  * Never represent money as doubles, use ints for the amount of pennies
  * Uses default visibilities of public
  */
object Demo2 extends App{
  class Account(name:String, var balance:Int) {
    def description:String = name + " $" + balance

    def deposit(amount:Int): Boolean = {
      if (amount >= 0){
        balance += amount
        true
      } else false
    }

    def withdraw(amount:Int): Boolean = {
      if(amount <= balance && amount >= 0){
        balance -= amount
        true
      }else false
    }

    def isEmpty:Boolean = balance==0.0
  }

  val account = new Account("Cameron", 100)
  println(account.description)

  account.withdraw(90)
  println(account.description) //large decimal
  account.withdraw(10)
  if(account.isEmpty) println("All money gone.") else println("Still got some...")
  println(account.description) //has an extremely small negative value

  //I can change the balance..not really a good practice
  account.balance = -999
  println(account.description)

}


/**
  * Demo3 demonstrates a Bank Account class
  * Never represent money as doubles, use ints for the amount of pennies
  * Uses private visibility for balance
  */
object Demo3 extends App{
  class Account(name:String, bal:Double) {
    private var balance = (bal*100).toInt

    def description:String = name + " $" + balance

    def deposit(amount:Double): Boolean = {
      if (amount >= 0){
        balance += (amount * 100).toInt
        true
      } else false
    }

    def withdraw(amount:Double): Boolean = {
      if(amount <= balance && amount >= 0){
        balance -= (amount * 100).toInt
        true
      }else false
    }

    def isEmpty:Boolean = balance==0.0
  }

  val account = new Account("Cameron", 1.00)
  println(account.description)

  account.withdraw(.9)
  println(account.description) //large decimal
  account.withdraw(.1)
  if(account.isEmpty) println("All money gone.") else println("Still got some...")
  println(account.description) //has an extremely small negative value
  //println(account.bal) //can't do it since bal is not a member


 // account.balance = -999 this line now throws and error
  println(account.description)
}

/**
  * Demo4 demonstrates scoped-private visibility
  * Default visibility is package-private: variable is private to the defining package scope
  * Scala allows you to define the visibility to any enclosing scope
  * private[this] is the most restrictive private--it is private to the current instance!
  */
object Demo4 extends App{
  class Point(private[this] var _x:Double, private var _y: Double){
    def x: Double = _x
    def y: Double = _y

    def += (pt: Point): Point = {
     // _x += pt._x this will throw an error whereas package-private will allow it
      _y += pt.y
      this
    }
  }
}

/***
  * Bank Account Demo with private[this] on the balance
  * Without [this], another bank account object has potential to modify the other
  */
object Demo5 extends App{
  class Account(name:String, bal:Double) {
    private[this] var balance = (bal*100).toInt

    def description:String = name + " $" + balance

    def deposit(amount:Double): Boolean = {
      if (amount >= 0){
        balance += (amount * 100).toInt
        true
      } else false
    }

    def withdraw(amount:Double): Boolean = {
      if(amount <= balance && amount >= 0){
        balance -= (amount * 100).toInt
        true
      }else false
    }

    def isEmpty:Boolean = balance==0.0
  }

  val account = new Account("Cameron", 1.00)
  println(account.description)

  account.withdraw(.9)
  println(account.description) //large decimal
  account.withdraw(.1)
  if(account.isEmpty) println("All money gone.") else println("Still got some...")
  println(account.description) //has an extremely small negative value
  //println(account.bal) //can't do it since bal is not a member


  // account.balance = -999 this line now throws and error
  println(account.description)
}


/***
  * Demo6 demonstrates protected with inheritance
  */
object Demo6 extends App{
  class A{
     protected def greet : String = "hello"
  }

   class B extends A
  {
    override def greet: String = super.greet //overriding greet, using super to refer to parent
  }

  println((new B).greet)


  abstract class Student(protected var name:String, protected var GPA:Double)

  class CSStudent(name:String, GPA:Double) extends Student(name, GPA){
    override def toString: String = s"$name as a $GPA gpa"
  }

  val me:CSStudent = new CSStudent("Cameron", 3.8)

  println(me)
}