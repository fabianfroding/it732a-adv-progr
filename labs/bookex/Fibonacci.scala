object Fibonacci {
    def fibonacci(n: Int): Int = {
        if (n <= 0) {
            0
        }
        else if (n == 1) {
            1
        } else {
            fibonacci(n - 1) + fibonacci(n - 2)
        }
    }

    def formatFibonacci(n: Int) = {
        val msg = "The fibonacci number at %d is %d"
        msg.format(n, fibonacci(n))
    }

    def main(args: Array[String]): Unit = {
        println(formatFibonacci(3))
    }
}