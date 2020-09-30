/**
* University of Skövde
* Course: Advanced Programming
*/

package linalg

/**
* This Matrix class represent (basically) a collection of vectors.
*
* @param data Where the values of the vector are held.
*/
class Mat(val data: Lista[Vec]) {

  // ============== Some already implemented methods  ===============

  /**
  * Returns the number of elements in the matrix.
  *
  * @return number of elements.
  */
  def size: Int = data.map(_.size).reduce(_ + _)

  /**
  * Returns the shape in terms of rows and columns.
  *
  * @return a tuple, where the first element are the number of rows, and the
  *   second the number of columns.
  */
  def shape: (Int, Int) = (data.size, data.head.size)

  /**
  * Compares whether this matrix is equal to another in terms of its elements.
  * Mainly required for testing.
  *
  * @param other the other matrix with which to compare.
  *
  * @return true if shape and elements are equal, false otherwise.
  */
  def equals(other: Mat): Boolean = {
    shape == other.shape &&
    data.zip(other.data).forall{ case (a: Vec, b: Vec) => a equals b}
  }

  /**
  * Prettyfies the output of a matrix.
  */
  override def toString: String = {
    data.map(_.toString).reduce(_ + "\n" + _)
  }


  // =================================================================
  // ===================== Your working area =========================

  // ------- Selecting and slicing -------

  /**
  * Returns the ith row (if axis == 0) or a column (if axis == 1).
  *
  * @param i the ith row or column that is to be returned.
  * @param axis 0 for selecting a row, 1 for selecting a column.
  *
  * @return a vector corresponding to the selected row or column.
  */
  def apply(i: Int, axis: Int): Vec = {
    def getRow(l: Lista[Vec], n: Int): Vec = {
      if (l.tail.size > 0) {
        if (n == i) l.head
        else getRow(l.tail, n + 1)
      }
      else l.head
    }

    def getColumn(l: Lista[Vec], res: Lista[Double]): Vec = {
      if (l.tail.size > 0) getColumn(l.tail, Cons(l.head.apply(i), res))
      else Vec(Cons(l.head.apply(i), res).reverse)
    }

    if (axis == 0) getRow(this.data, 0)
    else if (axis == 1) getColumn(this.data, Lista[Double]())
    else throw new Exception("Undefined axis")
  }

  /**
  * Returns the rows (if axis == 0), or columns (if axis == 1), between the given
  * range (inclusive). Check the scala API for Range.
  */
  def apply(range: Range, axis: Int): Mat = {
    def getRows(l: Lista[Vec], i: Int, res: Lista[Vec]): Mat = {
      if (range.start < 0 || range.end > l.size-1) throw new Exception("Range out of bounds")
      if (i <= range.end) {
        getRows(l, i + 1, Cons(l.apply(i), res))
      }
      else {
        Mat(res.reverse)
      }
    }

    // TODO: getColumns
    def getColumns(l: Lista[Vec], i: Int, res: Lista[Vec]): Mat = {
      
    }

    if (axis == 0) getRows(this.data, range.start, Lista[Vec]())
    else if (axis == 1) getRows(this.data, range.start, Lista[Vec]())
    else throw new Exception("Undefined axis")
  }



  // ------- Element-wise operations -------

  /**
  * The following operations are element-wise. That is, each opeartion will
  * result in a new matrix of the same shape, but with each element equal to
  * the corresponding operation.
  * There are three groups: operations with Doubles, with Vectors, and with Matrices.
  * Examples:
  *   m = [[1, 1], [2, 2]]
  *   v = [2, 2]
  *
  *   With doubles:
  *   m + 1 == [[2, 2], [3, 3]]
  *   m - 1 == [[0, 0], [1, 1]]
  *
  *   With Vectors:
  *   m * v == [[2, 2], [4, 4]]
  *
  *   With Matrices:
  *   m / m == [[1, 1], [1, 1]]
  *
  * Notes:
  * - For Vector operations you may assume that the size of the vector is
  *   equal to the number of columns in the matrix.
  * - For Matrix operations you may assume that both matrices are of the same shape.
  * - Take into account that subtraction and division are non-associative! (v - m != m - v).
  */

  def +(x: Double): Mat = ???
  def *(x: Double): Mat = ???
  def -(x: Double): Mat = ???
  def /(x: Double): Mat = ???

  def +(x: Vec): Mat = ???
  def *(x: Vec): Mat = ???
  def -(x: Vec): Mat = ???
  def /(x: Vec): Mat = ???

  def +(x: Mat): Mat = ???
  def *(x: Mat): Mat = ???
  def -(x: Mat): Mat = ???
  def /(x: Mat): Mat = ???


  /**
  * Sums each element in the matrix.
  */
  def sum: Double = ???


  // ------- Transposing -------

  /**
  * Transposes the matrix (see exercise 6.6).
  */
  def t: Mat = ???


  // ------- Dot product / Matrix multiplication -------

  /**
  * Performs a row-wise dot product (see exercise 2.11).
  */
  def dot(vec: Vec): Mat = ???

  /**
  * Performs a matrix mutiplication (see exercise 6.7)
  */
  def dot(m: Mat): Mat = ???

}



/**
* Companion object of Mat.
* Defines comodity methods for instantiating a matrix.
*/
object Mat {
  def apply(vecs: Lista[Vec]): Mat = new Mat(vecs)

  def apply(vecs: Vec*): Mat = Mat(Lista(vecs:_*))
}
