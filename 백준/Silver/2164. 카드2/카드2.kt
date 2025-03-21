fun main() {
    val n = readLine()!!.toInt()
    val queue = ArrayDeque<Int>()
    queue.addAll(1..n)

    while (queue.size != 1) {
        queue.removeFirst()
        queue.addLast(queue.removeFirst())
    }

    println(queue.first())
}