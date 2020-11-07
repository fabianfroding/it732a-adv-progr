object Hofstadter {
    def hofstadter(n: Int): Int = {
        if (n > 0) n - hofstadter(hofstadter(n - 1))
        else 0
    }

    def hofStream(n: Int = 0, acc: Int = 0): Stream[Int] = {
        def hoof(n: Int): Int = {
            if (n > 0) n - hoof(hoof(n - 1))
            else 0
        }
        //Stream.cons(n, numbersFrom(n + 1))
        def go(n: Int): Stream[Int] = n #:: go(hofstadter(n+1))
        go(0)
    }

    def main(args: Array[String]): Unit = {
        println(hofstadter(8))
        println(hofStream().take(8).toList)
    }
}