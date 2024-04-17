package Chapter4

open class RichButton : Clickable {
    fun disable() {}    // 하위 클래스에서 오버라이드 불가
    open fun animate() {} // 하위 클래스에서 오버라이드 가능
    override fun click() {} // 오버라이드한 메서드는 기본적으로 열려있다. RichButton을 상속하는 클래스는 click 함수를 오버라이드할 수 있다.
}