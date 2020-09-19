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
  def apply(i: Int): Double = ???

  /**
  * Returns the ith element.
  *
  * @param i index in the vector (0-indexed).
  * @return the ith element in the vector.
  */
  def apply(range: Range): Vec = ???



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

  def +(x: Double): Vec = ???
  def +(x: Vec): Vec = ???
  def +(x: Mat): Mat = ???

  def *(x: Double): Vec = ???
  def *(x: Vec): Vec = ???
  def *(x: Mat): Mat = ???

  def -(x: Double): Vec = ???
  def -(x: Vec): Vec = ???
  def -(x: Mat): Mat = ???

  def /(x: Double): Vec = ???
  def /(x: Vec): Vec = ???
  def /(x: Mat): Mat = ???


  /**
  * Sums all elements in the vector.
  */
  def sum: Double = ???


  // ------- Dot product / Matrix multiplication -------

  /**
  * Performs dot product (see exercise 2.11).
  */
  def dot(vec: Vec): Double = ???

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
