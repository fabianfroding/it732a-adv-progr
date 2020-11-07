import scala.collection.immutable.Stream.cons

object FibonacciStream {
    def numbersFrom(n: Int): Stream[Int] = {
        //Stream.cons(n, numbersFrom(n + 1))
        println(n)
        n #:: numbersFrom(n + 1)
    }

    def fibonacciStream(): Stream[Int] = {
       // 1 #:: 2 #:: Stream.cons(fibonacci(i - 1) + fibonacci(i - 2))
        def go(a: Int, b: Int): Stream[Int] = a #:: go(b, a + b)
        go(0, 1)
    }

    def main(args: Array[String]): Unit = {
        println(fibonacciStream().take(8).toList)
        println(numbersFrom(5).take(3).toList)
    }
}