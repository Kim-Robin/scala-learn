package part1basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorial(n: Int): BigInt = 
    if (n <= 1) 1
    else {
      // println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      // println("Computing factorial of " + n)

      result
    }

  // println("factorial: " + factorial(200000))
  // println(factorial(50000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = 
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
   */

  println("anotherFactorial: " + anotherFactorial(2000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
   * 1. Concatenate a string n times
   * 2. IsPrime function tail recursive
   * 3. Fibonacci function, tail recursive
   */

  @tailrec
  def concateString(n: Int, value: String, accumulator: String): String = {
    if (n <= 0) accumulator
    else concateString(n - 1, value, accumulator + value)

  }

  println("concateString: " + concateString(100, "hello", ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(t: Int, last: Int, nextToLast: Int) : Int =
      if (t >= n) last + nextToLast
      else fibonacciTailrec(t + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(3, 1, 1)
  }

  println(fibonacci(8))
}
