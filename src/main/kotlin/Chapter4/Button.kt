package Chapter4

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff() // 상위 타입의 이름을 <> 사이에 넣어서 super 키워드를 통해 상속한 상위 타입에 접근할 수 있다.
        super<Focusable>.showOff() // 상위 타입의 이름을 <> 사이에 넣어서 super 키워드를 통해 상속한 상위 타입에 접근할 수 있다.     }
    }
}