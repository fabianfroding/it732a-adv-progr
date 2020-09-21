object Curry {
    def curry(a: Int) = (b: Int) => a + b

    def mergeLists(a: List[Int], merge: (Int, Int) => Int) = (b: List[Int]) => {
        def go(a: List[Int], b: List[Int], merge: (Int, Int) => Int, res: List[Int]): List[Int] = {
            // Assume equal length
            if (!a.tail.isEmpty && !b.tail.isEmpty) {
                go(a.tail, b.tail, merge, res :+ merge(a.head, b.head))
            }
            else {
                res :+ merge(a.head, b.head)
            }
        }

        go(a, b, merge, List[Int]())
    }

    def main(args: Array[String]): Unit = {
        println(curry(1)(2))

        val a = List(3, 7, 2, 9)
        val b = List(1, 8, 4, 6)
        val prod = (x: Int, y: Int) => x * y // merge function
        println(mergeLists(a, prod)(b))

        //println(a ++ b)

        //println(merge(a, prod))
    }
}