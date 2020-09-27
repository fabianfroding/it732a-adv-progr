/**
* University of Skövde
* Course: Advanced Programming
*/

package linalg

/**
* This Vector class represent a specialized collection of (for simplicity) just
* Doubles.
*
* @param data Where the values of the vector are held.
*/
class Vec(val data: Lista[Double]) {

  // ============== Some already implemented methods  ===============

  /**
  * Returns the number of elements in the vector.
  *
  * @return number of elements.
  */
  def size: Int = data.size

  /**
  * Returns the shape in terms of rows and columns.
  *
  * @return a tuple, where the first element are the number of rows (1 in this case),
  * and the second the number of columns (= size).
  */
  def shape: (Int, Int) = (1, data.size)

  /**
  * Compares whether this vector is equal to another in terms of its elements.
  * Mainly required for testing.
  *
  * @return true if shape and elements are equal, false otherwise.
  */
  def equals(other: Vec): Boolean = data == other.data

  /**
  * Prettyfies the output of a matrix.
  */
  override def toString: String = data.toString


  // =================================================================
  // ===================== Your working area =========================

  // ------- Selecting and slicing -------

  /**
  * Returns the ith element.
  *
  * @param i index in the vector (0-indexed).
  * @return the ith element in the vector.
  */
  def apply(i: Int): Double = {
    def go(l: Lista[Double], n: Int): Double = {
      if (l.tail.size > 0) {
        if (n == i) l.head
        else go(l.tail, n + 1)
      }
      else l.head
    }

    go(this.data, 0)
  }

  /**
  * Returns the elements between the given range (including the boundaries).
  *
  * @param range a range collection stating the beginning and ending of the selection.
  *     See https://www.scala-lang.org/api/current/scala/collection/immutable/Range.html
  * @return the ith element in the vector.
  */
  def apply(range: Range): Vec = {
    def go(l: Lista[Double], n: Int, res: Lista[Double]): Vec = {
      if (l.tail.size > 0) {
        if (n >= range.start && n <= range.end) go(l.tail, n + 1, Cons(l.head, res))
        else go(l.tail, n + 1, res)
      }
      else Vec(Cons(l.head, res).reverse())
    }

    go(this.data, 0, Lista[Double]())
  }



  // ------- Element-wise operations -------

  /**
  * The following operations are element-wise. That is, each opeartion will
  * result in a new vector (or matrix) of the same shape, but with each element equal to
  * the corresponding operation.
  * There are three groups: operations with Doubles, with Vectors, and with Matrices.
  * Examples:
  *   m = [[1, 1], [2, 2]]
  *   v = [2, 3]
  *
  *   With doubles:
  *   v + 5 == [7, 8]
  *   m - 5 == [-3, -2]
  *
  *   With Vectors:
  *   v * v == [4, 6]
  *
  *   With Matrices:
  *   v / m == [[2, 3], [1, 1.5]]
  *
  * Notes:
  * - For Vector operations you may assume that the sizes are equal.
  * - For Matrix operations you may assume that the size of this vector is equal
  *   to the number of columns in the matrix.
  * - Take into account that subtraction and division are non-associative! (v - m != m - v).
  */

  def +(x: Double): Vec = {
    def go(l: Lista[Double], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) go(l.tail, Cons(l.head + x, res))
      else Vec(Cons(l.head + x, res).reverse)
    }
    go(this.data, Lista[Double]())
  }
  def +(x: Vec): Vec = {
    def go(l: Lista[Double], x: Lista[Double], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) go(l.tail, x.tail, Cons(l.head + x.head, res))
      else Vec(Cons(l.head + x.head, res).reverse)
    }
    go(this.data, x.data, Lista[Double]())
  }
  def +(x: Mat): Mat = ???

  def *(x: Double): Vec = {
    def go(l: Lista[Double], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) go(l.tail, Cons(l.head * x, res))
      else Vec(Cons(l.head * x, res).reverse)
    }
    go(this.data, Lista[Double]())
  }
  def *(x: Vec): Vec = ???
  def *(x: Mat): Mat = ???

  def -(x: Double): Vec = {
    def go(l: Lista[Double], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) go(l.tail, Cons(l.head - x, res))
      else Vec(Cons(l.head - x, res).reverse)
    }
    go(this.data, Lista[Double]())
  }
  def -(x: Vec): Vec = ???
  def -(x: Mat): Mat = ???

  def /(x: Double): Vec = {
    def go(l: Lista[Double], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) go(l.tail, Cons(l.head / x, res))
      else Vec(Cons(l.head / x, res).reverse)
    }
    go(this.data, Lista[Double]())
  }
  def /(x: Vec): Vec = ???
  def /(x: Mat): Mat = ???


  /**
  * Sums all elements in the vector.
  */
  def sum: Double = {
    def go(l: Lista[Double], res: Double): Double = {
      if (l.tail.size > 0) go(l.tail, l.head + res)
      else l.head + res
    }

    go(this.data, 0)
  }


  // ------- Dot product / Matrix multiplication -------

  /**
  * Performs dot product (see exercise 2.11).
  */
  def dot(vec: Vec): Double = {
    def go(a: Lista[Double], b: Lista[Double], res: Double): Double = {
      if (a.tail.size > 0 && b.tail.size > 0) go(a.tail, b.tail, res + (a.head * b.head))
      else res + (a.head * b.head)
    }

    go(this.data, vec.data, 0)
  }

  /**
  * Performs a row-wise dot product (see exercise 2.11).
  */
  def dot(m: Mat): Vec = ???

}



/**
* Companion object of Vec.
* Defines comodity methods for instantiating a vector.
*/
object Vec {
  def apply(ns: Lista[Double]): Vec = new Vec(ns)

  def apply(ns: Double*): Vec = Vec(Lista(ns:_*))
}
