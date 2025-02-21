import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    val buildTime = IntArray(n + 1)
    val resultTime = IntArray(n + 1)

    for (i in 1..n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        buildTime[i] = input[0]

        for (j in 1 until input.size - 1) {
            val prev = input[j]
            graph[prev].add(i)
            inDegree[i]++
        }
    }

    val queue = ArrayDeque<Int>()

    for (i in 1..n) {
        if (inDegree[i] == 0) {
            queue.add(i)
            resultTime[i] = buildTime[i]
        }
    }

    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()

        for (next in graph[now]) {
            inDegree[next]--
            resultTime[next] = maxOf(resultTime[next], resultTime[now] + buildTime[next])

            if (inDegree[next] == 0) {
                queue.add(next)
            }
        }
    }

    for (i in 1..n) {
        println(resultTime[i])
    }
}
