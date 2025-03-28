import java.util.*

fun main() {
    val (n, e) = readLine()!!.split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(e) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val (v1, v2) = readLine()!!.split(" ").map { it.toInt() }

    val distFrom1 = dijkstra(n, graph, 1)
    val distFromV1 = dijkstra(n, graph, v1)
    val distFromV2 = dijkstra(n, graph, v2)

    val INF = Int.MAX_VALUE

    val route1 = safeSum(distFrom1[v1], distFromV1[v2], distFromV2[n])
    val route2 = safeSum(distFrom1[v2], distFromV2[v1], distFromV1[n])

    val answer = minOf(route1, route2)

    println(if (answer >= INF) -1 else answer)
}

fun dijkstra(n: Int, graph: Array<MutableList<Pair<Int, Int>>>, start: Int): IntArray {
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    dist[start] = 0
    pq.add(start to 0)

    while (pq.isNotEmpty()) {
        val (cur, cost) = pq.poll()

        if (cost > dist[cur]) continue

        for ((next, weight) in graph[cur]) {
            val nextCost = cost + weight
            if (nextCost < dist[next]) {
                dist[next] = nextCost
                pq.add(next to nextCost)
            }
        }
    }

    return dist
}

fun safeSum(vararg values: Int): Int {
    return if (values.any { it == Int.MAX_VALUE }) Int.MAX_VALUE
    else values.sum()
}
