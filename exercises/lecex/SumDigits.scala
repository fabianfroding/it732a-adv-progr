object SumDigits {
    def sumDigits(n: Int): Int = {
        def go(n: Int, res: Int): Int = {
            println(n)
            if (n <= 0) res
            else go(n / 10, res + (n % 10))
        }
        
        go(n, 0)
    }

    def formatSumDigits(n: Int) = {
        val msg = "The sum of the digits in %d is %d"
        msg.format(n, sumDigits(n))
    }

    def main(args: Array[String]): Unit = {
        println(formatSumDigits(5))
    }
}