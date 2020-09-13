object NthSmallNum {
    def nSmallest(l: List[Int], n: Int): Int = {
        // Algo: sort the list, then return he k-1th element

        def go(l: List[Int], n: Int, smallest: Int, orgL: List[Int]): Int = {
            if (n > 0 && !l.tail.isEmpty) {
                if (l.head < smallest) go(l.tail, n-1, l.head, l)
                else go(l.tail, n, smallest, l)
            }
            else {
                smallest
            }
            
        }

        if (l.isEmpty) 0
        else if (l.tail.isEmpty) l.head
        else go(l.tail, n, l.head, l)
    }

    def sort(l: List[Int]): List[Int] = {
        def go(l: List[Int], newL: List[Int]): List[Int] = {
            
        }

        go(l, List[Int]())
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