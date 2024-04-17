package Chapter1

import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main(args: Array<String>) {
    println("Hello, world!")
}

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

fun max2(a: Int, b: Int): Int = if ( a > b ) a else b

fun variables(args: Array<String>) {
    val question: String = "질문"
    val answer: Int = 123
//    answer = 445;

    var answer2 = 1234;
    answer2 = 456;

    println("Hello, $answer");
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!");

    var a = 1;
    var s1 = "a 는 ${a}입니다"
//    var s2 = "a 는 $a입니다"
}


fun classTest() {
    val person = Person2("Bob", true);
    println(person.name);
    println(person.isMarried);

//    person.name = "test";
    person.isMarried = false;


    val rectangle = Rectangle(1, 2)
    println(rectangle.isSquare);
}


fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}


fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) { // when 식의 인자로 아무 객체나 사용할 수 있다.
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color") // 매치되는 분기 조건이 없으면 이 문장을 실행한다.
    }


fun mixOptimized(c1: Color, c2: Color) =
    when { // when에 아무 인자도 없다.
        (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) ->
            Color.ORANGE

        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) ->
            Color.GREEN

        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) ->
            Color.INDIGO

        else -> throw Exception("Dirty color")
    }


//fun eval(e: Expr): Int =
//    when (e) {
//        is Num ->   // 인자 타입을 검사
//            e.value // 스마트 캐스트
//        is Sum ->
//            eval(e.right) + eval(e.left)
//        else ->
//            throw IllegalArgumentException("Unknown expression")
//    }



//fun evalWithLogging(e: Expr): Int =
//    when (e) {
//        is Num -> {
//            println("num: ${e.value}")
//            e.value // 블록의 마지막 식으로 e.value가 반환된다.
//        }
//        is Sum -> {
//            val left = evalWithLogging(e.left)
//            val right = evalWithLogging(e.right)
//            println("sum: $left + $right")
//            left + right // 블록의 마지막 식으로 식의 값이 반환된다.
//        }
//        else -> throw IllegalArgumentException("Unknown expression")
//    }



fun loop() {

    for (i in 1..100) {
        // 1..100 범위의 정수에 대해 이터레이션한다.
        print(i)
    }

    for (i in 100 downTo 1 step 2) { // 역방향 수열, 증가 값 step을 갖는 수열에 대해 이터레이션한다.
        print(i)
    }

    for (x in 0 until 10);

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary // c를 키로 c의 2진 표현을 맵에 넣는다. 자바 코드 binaryReps.put(c, binary) 와 같다.
    }
    for ((letter, binary) in binaryReps) { // 맵에 대해 이터레이션한다. 원소를 풀어서 letter, binary 변수에 저장 (구조 분해)
        println("$letter = $binary")
    }

    var list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {  // 인덱스와 함께 컬렉션을 이터레이션한다.
        println("$index: $element")
    }
}


fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'  // in 연산자
fun isNotDigit(c: Char) = c !in '0'..'9'  // !in 연산자
fun loop2(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('x'))
}


fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"  // 여러 범위 조건을 함께 사용해도 된다.
    else -> "I don't know…"
}

fun loop3(args: Array<String>) {
    println(recognize('8'))
}

fun readNumber(reader: BufferedReader) {
    val number = try {                       // try의 본문을 반드시 중괄호 { }로 둘러싸야 한다. 마지막 식의 값이 전체 결과 값이다.
        Integer.parseInt(reader.readLine())  // 예외가 발생하지 않으면 이 값을 사용한다.
    } catch (e: NumberFormatException) {
        null  // 예외가 발생하면 null 값을 사용한다.
    }

    println(number)
}

fun tryCatchTest(args: Array<String>) {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader) // "null" 출력
}