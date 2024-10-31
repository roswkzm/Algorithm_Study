import java.util.PriorityQueue

class Solution {
    // N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다.
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val roadMap = road.flatMap { listOf(it[0] to Pair(it[1], it[2]), it[1] to Pair(it[0], it[2])) }
            .groupBy({ it.first }, { it.second.first to it.second.second })
        val distances = IntArray(N) { Int.MAX_VALUE }

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(1 to 0)
        distances[0] = 0

        while (pq.isNotEmpty()) {
            val (currentVillage, currentCost) = pq.poll()!!

            for ((nextVillage, nextCost) in roadMap.getValue(currentVillage)) {
                val nextVillageCost = currentCost + nextCost
                if (nextVillageCost < distances[nextVillage - 1]) {
                    pq.offer(nextVillage to nextVillageCost)
                    distances[nextVillage - 1] = nextVillageCost
                }
            }
        }

        return distances.count { it <= k }
    }
}