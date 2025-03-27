fun main() {
    val n = readLine()!!.toInt()
    val visited = mutableSetOf<Int>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(n to 0)
    visited.add(n)

    while (queue.isNotEmpty()) {
        val (n, c) = queue.removeFirst()
        if (n == 1) {
            println(c)
            break
        }

        if (n % 3 == 0 && n / 3 !in visited) {
            queue.add(n / 3 to c + 1)
        }
        if (n % 2 == 0 && n / 2 !in visited) {
            queue.add(n / 2 to c + 1)
        }
        queue.add(n - 1 to c + 1)
    }
}