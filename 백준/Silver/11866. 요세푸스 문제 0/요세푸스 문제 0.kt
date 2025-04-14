import java.util.ArrayDeque

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>()
    val result = mutableListOf<Int>()

    for (i in 1..n) deque.add(i)

    while (deque.isNotEmpty()) {
        repeat(k - 1) {
            deque.addLast(deque.removeFirst())
        }
        result.add(deque.removeFirst())
    }

    println(result.joinToString(", ", prefix = "<", postfix = ">"))
}