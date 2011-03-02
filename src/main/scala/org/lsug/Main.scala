package org.lsug

import scalaz._
import Scalaz._

/**
 * User: Rustem Suniev
 * Email: rustem.suniev@gmail.com
 */

object Main {
  def main(args: Array[String]) {
    val st = genSeq(6,2).take(200)
    val ls = groupAndSort(st)
    ls.foreach {
      case (a, b) => println(a + ":" + "X" * b.size)
    }
  }

  def genSeq(numSides:Int,numDie:Int): Stream[Int] = {
     Stream.continually(diceRoll(numSides))
     //TODO execute function according to numDie's
  }

  val rnd:Int => Int = (n:Int) => util.Random.nextInt(n)

  def diceRoll(numSides:Int) = rnd(numSides) + 1

  def groupAndSort(st: Stream[Int]): List[(Int, Stream[Int])] = st.groupBy(identity).toList.sortBy(_._1)
}