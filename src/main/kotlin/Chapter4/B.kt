package Chapter4

class B {
    class A {}
    inner class C {
        fun getA(): A = this@Outer
    }
}