class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val roadMap = road.flatMap { listOf(it[0] to Pair(it[1], it[2]), it[1] to Pair(it[0], it[2])) }
            .groupBy({ it.first }, { it.second.first to it.second.second })
        val visited = IntArray(N) { Int.MAX_VALUE }
        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.add(1 to 0)
        visited[0] = 0

        while (queue.isNotEmpty()) {
            val (currentVillage, currentCost) = queue.removeFirst()

            for ((nextVillage, nextCost) in roadMap.getValue(currentVillage)) {
                val nextVillageCost = currentCost + nextCost
                if (nextVillageCost < visited[nextVillage - 1] && currentCost + nextCost <= k) {
                    queue.add(nextVillage to nextVillageCost)
                    visited[nextVillage - 1] = nextVillageCost
                }

            }
        }

        return visited.count{ it <= k }
    }
}