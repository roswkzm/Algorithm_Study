import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val n = readLine()!!.toInt()
    val queue = ArrayDeque(readLine()!!.split(" ").map { it.toInt() })
    val stack = Stack<Int>()
    var expected = 1

    while (queue.isNotEmpty()) {
        if (queue.first() == expected) {
            queue.removeFirst()
            expected++
        } else if (stack.isNotEmpty() && stack.peek() == expected) {
            stack.pop()
            expected++
        } else {
            stack.push(queue.removeFirst())
        }
    }

    while (stack.isNotEmpty() && stack.peek() == expected) {
        stack.pop()
        expected++
    }

    println(if (stack.isEmpty()) "Nice" else "Sad")
}