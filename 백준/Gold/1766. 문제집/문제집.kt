import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    val result = mutableListOf<Int>()

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b)
        inDegree[b]++
    }

    val pq = PriorityQueue<Int>()

    for (i in 1..n) {
        if (inDegree[i] == 0) pq.add(i)
    }

    while (pq.isNotEmpty()) {
        val current = pq.poll()
        result.add(current)

        for (next in graph[current]) {
            inDegree[next]--
            if (inDegree[next] == 0) pq.add(next)
        }
    }

    println(result.joinToString(" "))
}
