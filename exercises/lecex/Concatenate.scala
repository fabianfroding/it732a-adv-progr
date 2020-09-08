object Concatenate {
    def concatenate(l: List[Int], n: List[Int]): List[Int] = {
        def go(l: List[Int], n: List[Int], res: List[Int]): List[Int] = {
            if (!l.isEmpty) go(l.tail, n, l.head :: res) // NEEDS FIX
            else if (!n.isEmpty) go(l, n.tail, n.head :: res)
            else res
        }

        go(l, n, List[Int]())
    }

    def formatConcatenate(l: List[Int], n: List[Int]) = {
        val msg = "%s concatenated with %s is %s"
        msg.format(l, n, concatenate(l, n))
    }

    def main(args: Array[String]): Unit = {
        println(formatConcatenate(List(1, 2, 3), List(4, 5))) // = List(1, 2, 3, 4, 5)
        println(formatConcatenate(List(3), List(3, 4, 4))) // = List(3, 3, 4, 4)

    }
}