package Concurrency

/**
  * Demonstrates Actors concurrency
  * Akka is a toolkit and runtime for building highly concurrent, distributed, and fault-tolerant event-driven applications on the JVM.
  * Akka can be used with both Java and Scala. This guide introduces Akka by describing the Scala version of the Hello World example.
  * This Code won't compile since the akka.actor dependency is needed
  */

/*
object Demo extends App{
  class SimpleActor extends Actor{
    def receive = {
      case s:String => println("String: " + s)
      case i: Int => println("Number: " + i)
    }

    def foo = println("Normal method")

  }

  val system = ActorSystem()
  val actor = system.actorOf(Props[SimpleActor], "SimpleActor")

  println
  actor ! "Hi There." //feeding messages to the actor with !
  actor ! 42          //! happens on a separate thread
  actor.foo //this is not callable
}
*/



