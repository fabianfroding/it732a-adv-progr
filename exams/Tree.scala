sealed trait Tree[+A] {
    def elem: A
    def end: Tree[A]
    def zip[B](ns: Tree[B]): Tree[(A, B)]
    def adda[B](a: B): Tree[(A , B)]

}
case object Leaf extends Tree[Nothing] {
    def elem: Nothing = throw new Exception("FAIL")
    def end: Tree[Nothing] = throw new Exception("FAIL")
    def zip[B](ns: Tree[B]): Tree[(Nothing, B)] = Leaf
    def adda[B](a: B): Tree[(Nothing, B)] = Leaf

}
case class Branch[A](elem: A, left: Tree[A], right: Tree[A]) extends Tree[A] {
    def getElem(): A = {
        this.elem
    }

    def end: Tree[A] = {
        Leaf
    }

    def zip[B](ns: Tree[B]): Tree[(A, B)] = {
        Leaf
    }

    def adda[B](a: B): Tree[(A, B)] = {
        Leaf
    }

}