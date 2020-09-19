object Digits {
    def countDigits(n: Int): Int = {
        def go(n: Int, tot: Int): Int = 
            if (n < 1) tot
            else go(n / 10, tot + 1)

        go(n, 0)
    }

    def formatDigits(n: Int) = {
        val msg = "The number of digits in %d is %d"
        msg.format(n, countDigits(n))
    }

    def main(args: Array[String]): Unit = {
        println(formatDigits(4444))
    }
}