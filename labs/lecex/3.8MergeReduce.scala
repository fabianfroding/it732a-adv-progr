object MergeReduce {
    def mergeReduce(a: List[Int], b: List[Int], merge: (Int, Int) => Int, reduce: (Int, Int) => Int): Int = {
        1
    }

    def merge(a: List[Int], b: List[Int], merge: (Int, Int) => Int): List[Int] = {
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
        val a = List(3, 7, 2, 9)
        val b = List(1, 8, 4, 6)
        val prod = (x: Int, y: Int) => x * y // merge function
        val sum = (x: Int, y: Int) => x + y // reduce function
        println(mergeReduce(a, b, prod, sum)) // = 121

        // Temp test
        println(merge(a, b, prod))
    }
}