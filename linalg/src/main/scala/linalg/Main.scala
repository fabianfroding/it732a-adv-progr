package linalg

object Main {
    def testLista() = {
        println("Test merge:");
        val a = Lista(0, 1, 2, 3, 4, 5);
        val b = Lista(4, 5, 6, 7, 8, 9);
        println(a, b)
        println(" => ");
        println(a.merge(b, (x: Int, y: Int) => x * y));

        println("Test drop(2):");
        println(a);
        println(" => ");
        println(a.drop(2))

        println("Test take(2):");
        println(b);
        println(" => ");
        println(b.take(2))
    }

    def main(args: Array[String]): Unit = {
        //testLista()
    }
}