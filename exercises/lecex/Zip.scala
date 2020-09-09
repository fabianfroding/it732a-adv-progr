object Zip {
    def zip(l: List[Int], n: List[Int]): List[(Int, Int)] = {
        def go(l: List[Int], n: List[Int], res: List[(Int, Int)]): List[(Int, Int)] = {
            
        }

        if (l.isEmpty && n.isEmpty) Nil
        else if (!l.isEmpty && n.isEmpty) List(l.head, Nil)
        else if (l.isEmpty && !n.isEmpty) List(n.head, Nil)
        (l.head, n.head) :: zip(l.tail, n.tail)
    }

    def formatZip(l: List[Int], n: List[Int]) = {
        val msg = "%s and %s zipped is %s"
        msg.format(l, n, zip(l, n))
    }

    def main(args: Array[String]): Unit = {
        println(formatZip(List(1, 2, 3), List(6, 3, 4))) // = List((1, 6), (2, 3), (3, 4))
        println(formatZip(List(1, 2), List(6, 3, 4))) // = List((1, 6), (2, 3))
        println(formatZip(List(1, 2, 3), List(6))) // = List((1, 6))
    }
}