object Sum {
    def sum(n: Int): Int = {
        def go(n: Int, res: Int): Int =
            if (n <= 0) res
            else go(n - 1, n + res)
        
        go(n, 0)
    }

    def formatSum(n: Int) = {
        val msg = "The sum of all numbers <= %d is %d"
        msg.format(n, sum(n))
    }

    def main(args: Array[String]): Unit = {
        println(formatSum(10))
    }
}