object HasSubSeq {
    def hasSubsequence(l: List[Int], sub: List[Int]): Boolean = {
        if (l.head == sub.head && !l.tail.isEmpty && !sub.tail.isEmpty) hasSubsequence(l.tail, sub.tail)
        else if (l.head != sub.head && !sub.tail.isEmpty) hasSubsequence(l.tail, sub)
        else if (l.head == sub.head && sub.tail.isEmpty) true
        else false
    }

    def main(args: Array[String]): Unit = {
        val l = 1 to 10 toList; // Why does it only work with ;?
        println(hasSubsequence(l, List(1, 2))) // = true
        println(hasSubsequence(l, List(5, 6, 7))) // = true
        println(hasSubsequence(l, List(7, 8, 10))) // = false
    }
}