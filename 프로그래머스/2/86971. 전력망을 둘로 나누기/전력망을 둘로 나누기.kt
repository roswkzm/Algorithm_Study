import kotlin.math.abs

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE

        fun bfs(start: Int, combineWireMap: Map<Int, List<Int>>): Pair<Int, Int> {
            val visited = BooleanArray(n)
            val queue = ArrayDeque<Int>()
            queue.add(start)
            visited[start - 1] = true

            while (queue.isNotEmpty()) {
                val curPosition = queue.removeFirst()

                for (node in combineWireMap.getOrDefault(curPosition, listOf())) {
                    if (!visited[node - 1]) {
                        queue.add(node)
                        visited[node - 1] = true
                    }
                }
            }
            val visitedCount = visited.count { it }
            return visitedCount to n - visitedCount
        }

        for (i in wires.indices) {
            val wireList = wires.map { it.toMutableList() }.toMutableList()
            wireList.removeAt(i)
            val combineWires = wireList.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
                .groupBy({ it.first }, { it.second }).toMutableMap()
            val (visitCount, notVisitCount) = bfs(combineWires.keys.first(), combineWires)
            answer = minOf(answer, abs(visitCount - notVisitCount))
        }

        return answer
    }
}