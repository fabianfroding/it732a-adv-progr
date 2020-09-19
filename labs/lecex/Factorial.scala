object Factorial {
    def factorial(n: Int): Int = {
        def go(s: Int, n: Int, res: Int): Int = {
            if (s > n) res
            else go(s + 1, n, res * s)
        }

        go(1, n, 1)
    }

    def formatFactorial(n: Int) = {
        val msg = "The factorial of %d is %d"
        msg.format(n, factorial(n))
    }

    def main(args: Array[String]): Unit = {
        println(formatFactorial(7))
    }
}