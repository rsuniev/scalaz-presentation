package org.lsug

import scalaz._
import Scalaz._

/**
 * User: Rustem Suniev
 * Email: rustem.suniev@gmail.com
 */

object Main {
  def main(args: Array[String]) {
    val st = genSeq(numSides = 2,numDie = 2).take(200)
    val ls = groupAndSort(st)
    ls.foreach {
      case (a, b) => println(a + ":" + "X" * b.size)
    }
  }

  /*def genSeq(numSides:Int,numDie:Int): Stream[Int] = {
    def sum() = (for(_ <- 1 to numDie) yield diceRoll(numSides)) reduceLeft {_+_}
    Stream.continually(sum)
    //List.fill(10) (List.fill(3)(rnd(6)).sum)
  }*/

  def genSeq(numSides:Int,numDie:Int): Stream[Int] = {
    //Grouped returns an Interator???
    Stream.continually(rnd(numSides)).grouped(numDie).map(_.sum).toStream
    //how this can be of some help?
    //what if something went wrong with a dice
    //http://apocalisp.wordpress.com/2010/10/17/scalaz-tutorial-enumeration-based-io-with-iteratees/
  }

  val rnd:Int => Int = (n:Int) => util.Random.nextInt(n)

  def diceRoll(numSides:Int) = rnd(numSides) + 1

  def groupAndSort(st: Stream[Int]): List[(Int, Stream[Int])] = st.groupBy(identity).toList.sortBy(_._1)
}