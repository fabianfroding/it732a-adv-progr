object HasSubSeq {
    def hasSubsequence(l: List[Int], sub: List[Int]): Boolean = {
        true

        // Check if l.head == sub.head, if so: call recursivevely:
            // hasSubsequence(l.tail, sub.tail) IF they no longer match AND sub is NOT empty, return false
            // if they do match, call recursive again
            // if they no longer match AND sub is empty, return true
        // if not, move on to next l.head
    }

    def main(args: Array[String]): Unit = {
        val l = 1 to 10 toList; // Why does it only work with ;?
        println(hasSubsequence(l, List(1, 2))) // = true
        println(hasSubsequence(l, List(5, 6, 7))) // = true
        println(hasSubsequence(l, List(7, 8, 10))) // = false
    }
}