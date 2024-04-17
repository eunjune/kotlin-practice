import Chapter3.Button
import Chapter3.User
import Chapter3.View

fun collection() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun easyFunction() {
    val list = listOf(1, 2, 3)
    println(joinToString(list, "; ", "(", ")"))
    println(joinToString(list, separator = "; ", prefix = "(", postfix =")"))
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun extends() {
    println("kotlin".lastChar());

    val view: View = Button();
    view.click();
    view.showOff();
}

fun <T> List<T>.last() : T { return this[this.size-1] }
fun Collection<Int>.max() : Int { return 0 }
fun <T> listOf(vararg values:T): List<T> { return values.asList() }

infix fun Any.to(other: Any) = Pair(this, other)
fun collections(args: Array<String>) {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last()) // fourteenth

    val numbers = setOf(1, 14, 2)
    println(numbers.max()) // 14

    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(1.to("one"))  // 일반적인 방식으로 호출
    println(1 to "one")         // 중위 호출 방식으로 호출

    val (number, name) = 1 to "one"

}


fun regex(path: String) {
    println("12.345-6.A".split("\\\\.|-".toRegex()))
    println("12.345-6.A".split(".","-"))

    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")


    val regex = """(.+)/(.+)\\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun saveUser(user: User) {
    fun validate(user: User,
                 value: String,
                 fieldName: String) { // 한 필드를 검증하는 로컬함수 사용
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address") // 로컬 함수를 호출해서 각 필드 검증

    // 유저를 데이터베이스에 저장
}

