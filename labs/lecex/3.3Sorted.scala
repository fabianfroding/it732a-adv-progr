object Sorted {
    def sorted(l: List[Int], f: (Int, Int) => Boolean): Boolean = {
        if (!l.tail.isEmpty) {
            if (f(l.head, l.tail.head)) sorted(l.tail, f)
            else false
        }
        else {
            true
        }
    }

    def main(args: Array[String]): Unit = {
        println(sorted(List(1, 2, 3, 4, 5), (a, b) => a < b)) // = true
        println(sorted(List(1, 2, 3, 4, 5, 3), (a, b) => a < b)) // = false
    }
}