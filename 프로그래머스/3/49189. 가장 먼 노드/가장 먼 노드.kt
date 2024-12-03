class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        edge.forEach {
            val from = it[0]
            val to = it[1]
            graph.computeIfAbsent(from) { mutableListOf() }.add(to)
            graph.computeIfAbsent(to) { mutableListOf() }.add(from)
        }

        fun bfs(): Int {
            val visited = BooleanArray(n)
            val cost = IntArray(n)
            val queue = ArrayDeque<Pair<Int, Int>>()

            queue.add(1 to 0)
            visited[0] = true
            cost[0] = 0

            while (queue.isNotEmpty()) {
                val (node, currCost) = queue.removeFirst()
                for (nextNode in graph.getOrDefault(node, mutableListOf())) {
                    val nextNodeIndex = nextNode - 1
                    if (!visited[nextNodeIndex]) {
                        queue.add(nextNode to currCost + 1)
                        visited[nextNodeIndex] = true
                        cost[nextNodeIndex] = currCost + 1
                    }
                }
            }

            return cost.count { it == cost.maxOf { it } }
        }
        return bfs()
    }
}