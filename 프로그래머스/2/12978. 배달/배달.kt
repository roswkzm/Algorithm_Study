import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val roadMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for ((a, b, c) in road) {
            roadMap.getOrPut(a) { mutableListOf() }.add(b to c)
            roadMap.getOrPut(b) { mutableListOf() }.add(a to c)
        }

        val distances = IntArray(N) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(1 to 0)
        distances[0] = 0

        while (pq.isNotEmpty()) {
            val (node, cost) = pq.poll()

            for ((nextNode, nextCost) in roadMap.getValue(node)) {
                val nextNodeCost = cost + nextCost
                if (nextNodeCost < distances[nextNode - 1]) {
                    pq.add(nextNode to nextNodeCost)
                    distances[nextNode - 1] = nextNodeCost
                }
            }
        }
        
        return distances.count { it <= k }
    }
}