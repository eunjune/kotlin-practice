package Chapter2

enum class Color2(
    val r: Int, val g: Int, val b: Int  // 상수의 프로퍼티를 정한다.
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),  // 각 상수를 생성할 때 그에 대한 프로퍼티 값을 지정한다.
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // 반드시 세미콜론을 사용해야 한다.

    fun rgb() = (r * 256 + g) * 256 + b  // enum 클래스 안에서 메소드를 정의한다.
}