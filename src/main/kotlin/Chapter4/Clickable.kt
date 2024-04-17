package Chapter4

interface Clickable {
    fun click() // 일반 메서드 선언
    fun showOff() = println("I'm clickable!") // 디폴트 구현이 있는 메서드, (자바와 달리) 특정한 키워드가 필요하지 않다.
}