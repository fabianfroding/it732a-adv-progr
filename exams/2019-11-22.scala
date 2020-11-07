object exam20191122 {
    def foo(n: Int): List[Int] = {
        //println(n)
        if (n <= 0) {
            //println("Nil")
            Nil
        }
        else foo(n - 1) match {
            case Nil => n :: Nil
            case h :: t =>
                val x = h - n
                //println(h)
                if (x > 0 && !t.contains(x)) x :: foo(n - 1)
                else (h + n) :: foo(n - 1)
        }
    }

    def fooTail(n: Int): List[Int] = {
        def go(n: Int, res: List[Int]): List[Int] = {
            if (n <= 0) Nil
            else foo(n - 1) match {
                case Nil => n :: Nil
                case h :: t =>
                val x = h - n
                if (x > 0 && !t.contains(x)) x :: foo(n - 1)
                else (h + n) :: foo(n - 1)
            }
        }

        go(n, List[Int]())
    }

    def counts(ls: List[Int], f: Int => Boolean): List[Int] = {
        def go(nTrue: Int, nFalse: Int, ls: List[Int], f: Int => Boolean): List[Int] = {
            if (!ls.tail.isEmpty) {
                if (f(ls.head)) go(nTrue + 1, nFalse, ls.tail, f)
                else go(nTrue, nFalse + 1, ls.tail, f)
            }
            else {
                if (f(ls.head)) List[Int](nTrue + 1, nFalse)
                else List[Int](nTrue, nFalse + 1)
            }
        }

        go(0, 0, ls, f)
    }

    def countsPatternMatch(ls: List[Int], f: Int => Boolean): List[Int] = {
        def go(nTrue: Int, nFalse: Int, ls: List[Int], f: Int => Boolean): List[Int] = {
            !ls.tail.isEmpty match {
                case true => {
                    f(ls.head) match {
                        case true => go(nTrue + 1, nFalse, ls.tail, f)
                        case false => go(nTrue, nFalse + 1, ls.tail, f)
                    }
                }
                case false => {
                    f(ls.head) match {
                        case true => List[Int](nTrue + 1, nFalse)
                        case false => List[Int](nTrue, nFalse + 1)
                    }
                }
            }
        }

        go(0, 0, ls, f)
    }

    def main(args: Array[String]): Unit = {
        println(foo(6))
        println(fooTail(6))

        println(countsPatternMatch(List(1,2,3,4,5), x => x < 3))

        val t = (1, List(1,2,1,1))
        println(t._1)
        println(t._2)

        //val t = Node(2, 2, 2)
        //println(t)
    }
}