/*object Q2_20200122 {
    def countT(d: Int, n: Int): Int = {
        if (n != 0) {
            
        }
        else {

        }
    }

    def count(d: Int, n: Int): Int = {
        def go(n: Int, res: Int): Int = {
            if (n != 0) {
                if (n % 10 == d) go(n / 10, res + 1)
                else go(n / 10, res + 1)
            }
            else {
                res
            }
            
	    }
        go(d, n, 0)
    }



    def main(args: Array[String]): Unit = {
        println(count(8, 28367389))
    }
}*/