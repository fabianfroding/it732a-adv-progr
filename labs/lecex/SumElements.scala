object SumElements {
    def sum(l: List[Int]): Int = {
        if (l.isEmpty) 0
        else l.head + sum(l.tail)
    }

    def formatSum(l: List[Int]) = {
        val msg = "The sum of %s is %d"
        msg.format(l, sum(l))
    }

    def main(args: Array[String]): Unit = {
        println(formatSum(List(1, 2, 3, 4, 5)))
        println(formatSum(List(45, -3, 8, -23)))
    }
}