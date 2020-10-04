/**
* University of Skövde
* Course: Advanced Programming
*/

package object linalg {

  /**
  * This implict class will allow us to perform operations where Double comes first
  * e.g., 3 - Vec(1, 2, 3).
  */
  implicit class IntWrapper(n: Double) {

    /**
    * Since addition and multiplication are associative, we can just call
    * their corresponding implementation in Vec and Mat.
    */
    def +(x: Vec): Vec = x + n
    def +(x: Mat): Mat = x + n
    def *(x: Vec): Vec = x * n
    def *(x: Mat): Mat = x * n


    /**
    * These ones, however, are slightly different and you'll need to implement
    * them. Check Vec.scala or Mat.scala for more details on these operations.
    */
    def -(x: Vec): Vec = {
      def go(l: Lista[Double], res: Lista[Double]): Vec = {
        if (l.tail.size > 0) go(l.tail, Cons(n - l.head, res))
        else Vec(Cons(n - l.head, res).reverse)
      }
      go(x.data, Lista[Double]())
    }
    def -(x: Mat): Mat = {
      def goInner(i: Int, j: Int, res: Lista[Double]): Vec = {
        if (j < x.data.apply(i).size) goInner(i, j + 1, Cons(n - x.data.apply(i).apply(j), res))
        else Vec(res.reverse)
      }

      def go(i: Int, res: Lista[Vec]): Mat = {
        if (i < x.data.size) go(i + 1, Cons(goInner(i, 0, Lista[Double]()), res))
        else Mat(res.reverse)
      }

      go(0, Lista[Vec]())
    }

    def /(x: Vec): Vec = {
      def go(l: Lista[Double], res: Lista[Double]): Vec = {
        if (l.tail.size > 0) go(l.tail, Cons(n / l.head, res))
        else Vec(Cons(n / l.head, res).reverse)
      }
      go(x.data, Lista[Double]())
    }
    def /(x: Mat): Mat = {
      def goInner(i: Int, j: Int, res: Lista[Double]): Vec = {
        if (j < x.data.apply(i).size) goInner(i, j + 1, Cons(n / x.data.apply(i).apply(j), res))
        else Vec(res.reverse)
      }

      def go(i: Int, res: Lista[Vec]): Mat = {
        if (i < x.data.size) go(i + 1, Cons(goInner(i, 0, Lista[Double]()), res))
        else Mat(res.reverse)
      }

      go(0, Lista[Vec]())
    }
  }
}
