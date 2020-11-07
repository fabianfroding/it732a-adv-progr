object Q3_20200122 {
    def foo(n: Int, ns: List[Int], acc: Int = 0): (Int, List[Int]) = {
        println(n, ns, acc)
        if (ns == Nil) (acc, Nil)
        else if (ns.head != n) (acc, ns)
        else foo(n, ns.tail, acc + 1)
    }

    def las(ns: List[Int]): List[Int] = {
        if (ns == Nil) Nil
        else {
            println("foo")
            val t = foo(ns.head, ns)
            println("res")
            println(t._1)
            println(ns.head)
            t._1 :: ns.head :: las(t._2)
        }
    }


    def lasPM(ns: List[Int]): List[Int] = {
        ns match {
            case Nil => Nil
            case _ => {
                val t = foo(ns.head, ns)
                t._1 :: ns.head :: las(t._2)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        println(lasPM(List(1,2,1,1)))
    }
}