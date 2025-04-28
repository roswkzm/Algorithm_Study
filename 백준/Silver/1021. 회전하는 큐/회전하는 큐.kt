import java.util.ArrayDeque

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val targets = readLine()!!.split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>((1..n).toList())

    var count = 0

    for (target in targets) {
        while (deque.first() != target) {
            if (deque.indexOf(target) <= deque.size / 2) {
                deque.addLast(deque.removeFirst())
            } else {
                deque.addFirst(deque.removeLast())
            }
            count++
        }
        deque.removeFirst()
    }

    println(count)
}
