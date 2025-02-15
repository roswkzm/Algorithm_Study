import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()
    val nodeMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    repeat(E) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        nodeMap.computeIfAbsent(u) { mutableListOf() }.add(v to w)
    }

    val costs = mutableMapOf<Int, Int>()
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(K to 0)

    while (pq.isNotEmpty()) {
        val (currentNode, currentCost) = pq.poll()
        if (currentNode !in costs) {
            costs[currentNode] = currentCost

            for ((nextNode, cost) in nodeMap.getOrDefault(currentNode, mutableListOf())) {
                val nextCost = currentCost + cost
                pq.add(nextNode to nextCost)
            }
        }
    }

    for (i in 1..V) {
        println(costs[i] ?: "INF")
    }
}
