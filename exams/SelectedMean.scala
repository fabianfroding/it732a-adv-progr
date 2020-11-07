object SelectedMean {
    def selectedMean(l: List[(Double, Int)], n: Int): Double = {
        def go(l: List[(Double, Int)], n: Int, sum: Double, total: Int): Double = {
            if (l.isEmpty) sum / total
            else {
                if (n == l.head._2) go(l.tail, n, sum + l.head._1, total + 1)
                else go(l.tail, n, sum, total)
            }
        }

	    go(l, n, 0.0, 0)
    }


    def main(args: Array[String]): Unit = {
         println(selectedMean(List((2.0,0),(4.5,1),(1.2,1),(3.0,3),(4.4,1),(4.5,0), (1.7,0),(5.3,2),(2.0,3)), 3))
    }
}