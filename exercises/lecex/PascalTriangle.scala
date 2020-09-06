object PascalTriangle {
    def pascal(r: Int, c: Int): Int = {
        if (r == 0 || r == c) 1
        else pascal(r - 1, c - 1) + pascal(r - 1, c)
    }

    def formatPascal(r: Int, c: Int) = {
        val msg = "The pascal value at row %d and col %d is %d"
        msg.format(r, c, pascal(r, c))
    }

    def main(args: Array[String]): Unit = {
        println(formatPascal(1, 1))
        println(formatPascal(3, 2))
        //println(formatPascal(8, 4))
    }
}