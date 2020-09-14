object STD {
    def std(l: List[Int]): Double = {
        val meanVal = mean(l) // Could call the function each recursive call, but where is the optimality in that...?
        def go(l: List[Int], total: Double, nums: Int): Double = {
            if (l.tail.isEmpty) {
                println(math.sqrt(total + l.head))
                println(nums.toDouble)
                math.sqrt(total + l.head) / (nums).toDouble
            }
            else go(l.tail, total + math.pow(l.head - meanVal, 2), nums + 1)
        }

        go(l, 0, 0)
    }

    def mean(l: List[Int]): Double = {
        def go(l: List[Int], total: Int, nums: Int): Double = {
            if (l.tail.isEmpty) (total + l.head) / (nums + 1).toDouble
            else go(l.tail, total + l.head, nums + 1)
        }

        go(l, 0, 0)
    }

    def formatSTD(l: List[Int]) = {
        val msg = "The standard deviation of %s is %.5f"
        msg.format(l, std(l))
    }

    def formatMean(l: List[Int]) = {
        val msg = "The mean of %s is %.5f"
        msg.format(l, mean(l))
    }

    def main(args: Array[String]): Unit = {
        val l = List(10, 12, 23, 5, 16)
        println(formatMean(l))
        println(formatSTD(l)) // = 6.0464...
    }
}