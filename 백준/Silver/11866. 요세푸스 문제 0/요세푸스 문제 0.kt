import java.util.*

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList((1..n).toList())
    val result = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        repeat(k - 1) {
            queue.add(queue.poll())
        }
        result.add(queue.poll())
    }

    println(result.joinToString(", ", prefix = "<", postfix = ">"))
}