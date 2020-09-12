object PascalTriangle {
    def pascal(c: Int, r: Int): Int = {
        if (c == 0 || c == 1 || r == c) 1
        else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    // n = row, k = col
    def pascal2(n: Int, k: Int): Int = {
        if (n == 0 || n == 1 || n == k) 1
        else pascal(n - 1, k - 1) + pascal(n, k - 1)
    }

    def formatPascal(r: Int, c: Int) = {
        val msg = "The pascal value at row %d and col %d is %d"
        msg.format(r, c, pascal2(c, r))
    }

    def main(args: Array[String]): Unit = {
        println(formatPascal(1, 1)) // = 1
        println(formatPascal(3, 2)) // = 2
        println(formatPascal(8, 4)) // = 35
        println(formatPascal(3, 3)) // = 1
    }
}