object Count {
    def count(l: List[Int], f: Int => Boolean): Int = {
        def go(l: List[Int], f: Int => Boolean, total: Int): Int = {
            if (!l.tail.isEmpty) {
                if (f(l.head)) go(l.tail, f, total + 1)
                else go(l.tail, f, total)
            }
            else {
                if (f(l.head)) total + 1
                else total
            }
        }

        go(l, f, 0)
    }

    def main(args: Array[String]): Unit = {
        println(count(List(1, 2, 3, 4, 5), x => x % 2 == 0)) // = 2
        println(count(List(1, 2, 3, 4, 5), x => x % 2 != 0)) // = 3
    }
}