fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val network = mutableMapOf<Int, MutableList<Int>>()

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        network.computeIfAbsent(a) { mutableListOf() }.add(b)
        network.computeIfAbsent(b) { mutableListOf() }.add(a)
    }

    fun bfs(): Int {
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n + 1)
        var count = 0

        queue.add(1)
        visited[1] = true

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            for (nextNode in network.getOrDefault(node, mutableListOf())) {
                if (!visited[nextNode]) {
                    queue.add(nextNode)
                    visited[nextNode] = true
                    count++
                }
            }
        }
        return count
    }

    println(bfs())
}
