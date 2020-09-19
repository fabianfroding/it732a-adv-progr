object Map {
    def map(l: List[Int], f: Int => Int): List[Int] = {
        def go(l: List[Int], result: List[Int]): List[Int] = {
            if (!l.tail.isEmpty) {
                go(l.tail, result :+ f(l.head))
            }
            else {
                result :+ f(l.head)
            }
        }

        go(l, List[Int]())
    }

    def main(args: Array[String]): Unit = {
        println(map(List(1, 2, 3, 4, 5), x => x * x)) // = List(1, 4, 9, 16, 25)
        println(map(List(1, 2, 3, 4, 5), x => x * x * x)) // = List(1, 8, 27, 64, 125)
    }
}