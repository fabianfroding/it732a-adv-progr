object SquareElements {
    def square(l: List[Int]): List[Int] = {
        if (l.isEmpty) List()
        else math.pow(l.head, 2).toInt :: square(l.tail)
    }

    def formatSquare(l: List[Int]) = {
        val msg = "The squared list of %s is %s"
        msg.format(l, square(l))
    }

    def main(args: Array[String]): Unit = {
        println(formatSquare(List(1, 2, 3, 4, 5))) // = List(1, 4, 9, 16, 25)
        println(formatSquare(List(12, 56, 32))) // = List(144, 3136, 1024)
    }
}