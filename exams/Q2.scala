object Q2 {
    def fooT(n: Int): Int = {
        def go(n: Int, res: Int): Int = {
            if (n <= 1) res
            else go(n-1, res * n)
        }

        go(n, 1)
    }

    def foo(n: Int): Int = {
        if (n <= 1) 1
        else n * foo(n-1)
    }

    def main(args: Array[String]): Unit = {
        println(foo(5))
        println(fooT(5))
    }
}