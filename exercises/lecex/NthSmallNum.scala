object NthSmallNum {
    def nSmallest(l: List[Int], n: Int): Int = {
        def go(l: List[Int], n: Int, smallest: Int): Int = {
            if (l.tail.isEmpty) smallest
            else if (l.head < smallest) go(l.tail, n, l.head)
            else go(l.tail, n, smallest)
        }

        if (l.isEmpty) 0
        else if (l.tail.isEmpty) l.head
        else go(l.tail, n, l.head)
    }

    def formatNSmallest(l: List[Int], n: Int) = {
        val msg = "The %dth smallest number in %s is %d"
        msg.format(n, l, nSmallest(l, n))
    }

    def main(args: Array[String]): Unit = {
        val ns = List(3, 7, 1, 9, 3, 5, 8)
        println(formatNSmallest(ns, 2)) // = 3 (second smallest)
        println(formatNSmallest(ns, 4)) // = 5 (fourth smallest)
    }
}