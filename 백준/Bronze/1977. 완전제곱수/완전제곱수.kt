import kotlin.math.sqrt

fun main() {
    val (n, m) = IntArray(2) { readLine()!!.toInt() }
    val perfectSquareList = mutableListOf<Int>()

    fun isCurrent(n: Int): Boolean {
        val sqrt = sqrt(n.toDouble()).toInt()
        return sqrt * sqrt == n
    }

    for (i in n..m) {
        if (isCurrent(i)) perfectSquareList.add(i)
    }

    if (perfectSquareList.isEmpty()) {
        println(-1)
    } else {
        println(perfectSquareList.sumOf { it })
        println(perfectSquareList.minOf { it })
    }
}
