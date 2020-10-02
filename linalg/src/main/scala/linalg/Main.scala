package linalg

// This class is just for testing.

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

    def testVec() = {
        val l = Lista(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
        val v = Vec(l)
        println(v)

        println(v.apply(2))

        val r = 4 until 8
        println(v.apply(r))

        println(v.sum)

        val v2 = Vec(Lista(1.0, 2.0, 3.0))
        println(v2.dot(Vec(Lista(4.0, 5.0, 6.0))))

        println(v2 + v2)

        val vec = Vec(Lista(3.0, 7.0))
        println(vec * v2)

        val vecX = Vec(Lista(1.0,2.0,3.0,4.0))
        val mat = Mat(Lista(Vec(1.0,2.0,3.0,4.0), Vec(5.0,6.0,7.0,8.0), Vec(9.0,10.0,11.0,12.0)))
        vecX + mat

        println(vecX + mat)
    }

    def testMat() = {
        val mat = Mat(Lista(Vec(1,2,3,4,5), Vec(6,7,8,9,10), Vec(11,12,13,14,15)))
        //println(mat.apply(0, 1))

        //println(mat.apply(0 until 1, 0))
        println(mat.apply(2 until 2, 0))
    }

    def main(args: Array[String]): Unit = {
        //testLista()
        testVec()
        //testMat()
    }
}