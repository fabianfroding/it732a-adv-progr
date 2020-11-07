 import scala.collection.immutable.Stream.cons

object NaturalNumbers {
    def numbersFrom(n: Int): Stream[Int] = {
        Stream.cons(n, numbersFrom(n + 1))
    }

    def main(args: Array[String]): Unit = {
        println("test")
        println(Stream(1,2,3).take(2).toList)

        val st = 1 #:: 2 #:: 3 #:: Stream.empty
        println(st)

        val prep = st.take(2).print
        println(prep)

        val emp: Stream[Int] = Stream.empty[Int]
        println(emp)

        lazy val t = numbersFrom(5).take(8).toList
        println(t)
    }
}