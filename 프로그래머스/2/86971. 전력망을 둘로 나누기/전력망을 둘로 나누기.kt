import kotlin.math.abs

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE

        fun bfs(start: Int, wireMap: Map<Int, List<Int>>): Pair<Int, Int> {
            val visited = MutableList(n) { false }
            val queue = ArrayDeque<Int>()
            queue.add(start)
            visited[start - 1] = true

            while (queue.isNotEmpty()) {
                val currentPosition = queue.removeFirst()
                for (nextPosition in wireMap.getValue(currentPosition)) {
                    if (!visited[nextPosition - 1]) {
                        queue.add(nextPosition)
                        visited[nextPosition - 1] = true
                    }
                }
            }
            val visitCount = visited.count { it }
            return visitCount to n - visitCount
        }

        // i번째 전력망을 끊었을 경우
        for (i in wires.indices) {
            val wiresList = wires.map { it.toMutableList() }.toMutableList()
            wiresList.removeAt(i)

            val combinedMap = wiresList
                .flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
                .groupBy({ it.first }, { it.second })

            val (visitCount, notVisitCount) = bfs(combinedMap.keys.first(), combinedMap)
            answer = minOf(answer, abs(visitCount - notVisitCount))
        }


        return answer
    }
}