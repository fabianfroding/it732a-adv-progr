object GCD {
    def gcd(n: Int, k: Int): Int = {
        // Need to nest the loop to compare each divisor of n with each diisor of k... O(n^(k))...

        def go(n: Int, k: Int, i: Int): Int = {
            if (i > 0) {
                println("%d / %d is %d".format(n, i, n/i))
                println("%d / %d is %d".format(k, i, k/i))
            }
            
            if (i == 0 || n / i == k / i) i
            else go(n, k, i - 1)
        }

        go(n, k, if (n > k) n else k)
    }

    def formatGCD(n: Int, k: Int) = {
        val msg = "The greatest common divisor of %d and %d is %d"
        msg.format(n, k, gcd(n, k))
    }

    def main(args: Array[String]): Unit = {
        println(formatGCD(54, 24))
    }
}