object Fibonacci {
    def fibonacci(i: Int): Int = {
        if (i == 0) 0
        else if (i == 1) 1
        else {
            fibonacci(i - 1) + fibonacci(i - 2)
        }
    }

    def formatFibonacci(i: Int) = {
        val msg = "The fibonacci number at position %d is %d"
        msg.format(i, fibonacci(i))
    }
    

    def main(args: Array[String]): Unit = {
        println(formatFibonacci(4))
        println(formatFibonacci(7))
        println(formatFibonacci(12))
    }
}