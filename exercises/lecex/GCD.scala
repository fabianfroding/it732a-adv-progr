object GCD {
    def gcd(n: Int, k: Int): Int = {
        /* n % k gives us the remainder of how many k's goes into n.
            Ex: n = 54, k = 24: 24 goes into 54 two times, leaving 6 behind.
            We then call gcd recursively with 6 as k parameter, resulting in:
            gcd(24, 6) -> 24 % 6 = 0 ->
            The next iteration then gives us:
            gcd(6, 0) -> 6

            gcd(54, 24)
            gcd(24, 6)
            gcd(6, 0)
            Right value shifts to left each iteration.
        */
        // If the second number is 0, we have found the GCD.
        if (k == 0) n else gcd(k, n % k)
    }

    def formatGCD(n: Int, k: Int) = {
        val msg = "The greatest common divisor of %d and %d is %d"
        msg.format(n, k, gcd(n, k))
    }

    def main(args: Array[String]): Unit = {
        println(formatGCD(54, 24))
        println(formatGCD(10, 55)) // = 5
        println(formatGCD(21, 9)) // = 3
        println(formatGCD(11, 23))
    }
}