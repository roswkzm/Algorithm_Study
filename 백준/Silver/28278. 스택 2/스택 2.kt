import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val stack = ArrayDeque<Int>()

    val n = br.readLine().toInt()
    repeat(n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "1" -> stack.addLast(command[1].toInt())
            "2" -> sb.appendLine(if (stack.isEmpty()) -1 else stack.removeLast())
            "3" -> sb.appendLine(stack.size)
            "4" -> sb.appendLine(if (stack.isEmpty()) 1 else 0)
            "5" -> sb.appendLine(if (stack.isEmpty()) -1 else stack.last())
        }
    }

    print(sb)
}