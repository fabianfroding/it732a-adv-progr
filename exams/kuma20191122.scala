object Kuma20191122 {
    def foo(n: Int): List[Int] = {
       if (n <= 0) Nil
       else foo(n - 1) match {
           case Nil => n :: Nil
           case h :: t => {
               val x = h - n
               if (x > 0 && !t.contains(x)) {
                   println("if", n)
                   x :: foo(n - 1)
               }
               else {
                   println("else", n)
                   (h + n) :: foo(n - 1)
               }
           }
       } 
    }

    def main(args: Array[String]): Unit = {
        println(foo(6))
    }
}