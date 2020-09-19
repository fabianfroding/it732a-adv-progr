object FindMax {
    def max(l: List[Int]): Int = {
        def go(l: List[Int], m: Int): Int = {
            if (!l.tail.isEmpty) {
                if (m < l.tail(0)) go(l.tail, l.tail(0))
                else go(l.tail, m)
            }
            else {
                m
            }
        }

        go(l, l.head)
    }

    def formatMax(l: List[Int]) = {
        val msg = "The max value in %s is %d"
        msg.format(l, max(l))
    }

    def main(args: Array[String]): Unit = {
        println(formatMax(List(1, 6, 3, 7, 2))) // = 7
        println(formatMax(List(-1, 56, 34, -43, 4, 110))) // = 110
        println(formatMax(List(5))) // = 5
    }
}