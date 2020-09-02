object SumDigits {
    def sumDigits(n: Int): Int = {
        def go(n: Int, res: Int): Int =
            0
        
        go(n, 0)
    }

    def formatSumDigits(n: Int) = {
        val msg = "The sum of the digits in %d is %d"
        msg.format(n, sumDigits(n))
    }

    def main(args: Array[String]): Unit = {
        println("woos")
    }
}