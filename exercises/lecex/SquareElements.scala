object SquareElements {
    def square(l: List[Int]): List[Int] = {
        newL = List[Int]
        math.sqrt(l.head) + square(l.tail)
    }

    def formatSquare(l: List[Int]) = {
        val msg = "The squared list of %s is %s"
        msg.format(l, square(l))
    }

    def main(args: Array[String]): Unit = {

    }
}