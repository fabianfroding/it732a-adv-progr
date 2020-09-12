object NthSmallNum {
    def nSmallest(l: List[Int], n: Int): Int = {
        1
    }

    def formatNSmallest(l: List[Int], n: Int) = {
        val msg = "The %d smallest number in %s is %d"
        msg.format(n, l, nSmallest(l, n))
    }

    def main(args: Array[String]): Unit = {
        val ns = List(3, 7, 1, 9, 3, 5, 8)
        println(formatNSmallest(ns, 2)) // = 3 (second smallest)
        println(formatNSmallest(ns, 4)) // = 5 (fourth smallest)
    }
}