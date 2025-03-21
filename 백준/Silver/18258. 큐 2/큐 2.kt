fun main() {
    val n = readLine()!!.toInt()
    val queue = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val commend = readLine()!!.split(" ")
        when (commend[0]) {
            "push" -> queue.add(commend[1].toInt())
            "pop" -> sb.appendLine(queue.removeFirstOrNull() ?: -1)
            "size" -> sb.appendLine(queue.size)
            "empty" -> sb.appendLine(if (queue.isEmpty()) 1 else 0)
            "front" -> sb.appendLine(queue.firstOrNull() ?: -1)
            "back" -> sb.appendLine(queue.lastOrNull() ?: -1)
        }
    }
    println(sb)
}