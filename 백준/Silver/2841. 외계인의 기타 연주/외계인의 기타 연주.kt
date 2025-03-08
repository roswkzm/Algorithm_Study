import java.util.*

fun main() {
    val (n, p) = readLine()!!.split(" ").map { it.toInt() }
    val stacks = Array(n + 1) { Stack<Int>() }
    var moves = 0
    repeat(n) {
        val (line, fret) = readLine()!!.split(" ").map { it.toInt() }
        val currentStack = stacks[line]

        while (currentStack.isNotEmpty() && currentStack.peek() > fret) {
            currentStack.pop()
            moves++
        }

        if (currentStack.isEmpty() || currentStack.peek() != fret) {
            currentStack.add(fret)
            moves++
        }
    }
    println(moves)
}
