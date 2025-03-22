import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val input = readLine()!!.split(" ").map { it.toInt() }
    val deque: Deque<Pair<Int, Int>> = ArrayDeque()

    for (i in 1..n) {
        deque.add(Pair(i, input[i - 1]))
    }

    val result = mutableListOf<Int>()

    while (deque.isNotEmpty()) {
        val (index, move) = deque.removeFirst()
        result.add(index)

        if (deque.isEmpty()) break

        if (move > 0) {
            repeat(move - 1) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            repeat(-move) {
                deque.addFirst(deque.removeLast())
            }
        }
    }

    println(result.joinToString(" "))
}