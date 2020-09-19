object Reverse {
    def reverse(l: List[Int]): List[Int] = {
        def go(l: List[Int], res: List[Int]): List[Int] = {
            if (l.isEmpty) res
            else go(l.tail, l.head :: res)
        }

        go(l, List[Int]())
    }

    def formatReverse(l: List[Int]) = {
        val msg = "%s reversed is %s"
        msg.format(l, reverse(l))
    }

    def main(args: Array[String]): Unit = {
        println(formatReverse(List(1, 2, 3, 4))) // = List(4, 3, 2, 1)
        println(formatReverse(List(0, 34, -43, 4, 110))) // = List(110, 4, -43, 34, 0)
        println(formatReverse(List(5))) // = List(5)
    }
}