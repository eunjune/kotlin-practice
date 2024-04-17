package Chapter4

abstract class Animated {
    abstract fun animate()  // 추상 메서드의 경우 구현이 없고 추상 클래스를 상속하는 클래스에서 반드시 오버라이드 해야한다.

    open fun stopAnimating() {} // 추상 클래스에 있더라도 비추상 메서드는 기본적으로 final이지만 open 변경자를 통해 오버라이드를 허용할 수 있다.
    fun animateTwice() {}   // 기본적으로 final이다.
}