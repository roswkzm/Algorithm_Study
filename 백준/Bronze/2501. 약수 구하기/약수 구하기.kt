import java.lang.Math.sqrt

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    for (i in 1..sqrt(a.toDouble()).toInt()) {
        if (a % i == 0) {
            list.add(i)
            if (i != a / i) { // 제곱수가 아닐 때만 추가
                list.add(a / i)
            }
        }
    }
    list.sort()
    println(list.getOrNull(b - 1) ?: 0)
}