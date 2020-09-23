package linalg

object Main {

    def main(args: Array[String]): Unit = {
        println("Hey");
        val a = Lista(1, 2, 3);
        val b = Lista(4, 5, 6);
        val c = Lista(9);
        val d = Lista();

        val e = Cons(1, a);

        val ab = a.merge(b, (x: Int, y: Int) => x * y);

        println(ab);
    }
}