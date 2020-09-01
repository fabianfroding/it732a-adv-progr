object Sum {
    def sum(i: Int, n: Int): Int = {
        if (n <= 0) {
            0
        }
        else if (n == 1) {
            1
        } else {
            sum(n - 1) + sum(n - 2)
        }
    }

    def formatSum(n: Int) = {
        val msg = "The sum of all numbers <= %d is %d"
        msg.format(n, sum(0, n))
    }

    def main(args: Array[String]): Unit = {
        println(formatSum(10))
    }
}