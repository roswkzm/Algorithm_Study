class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edge) {
            graph.computeIfAbsent(a) { mutableListOf() }.add(b)
            graph.computeIfAbsent(b) { mutableListOf() }.add(a)
        }
        val costs = IntArray(n)
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = BooleanArray(n)

        queue.add(1 to 0)
        costs[0] = 0
        visited[0] = true

        while (queue.isNotEmpty()) {
            val (node, cost) = queue.removeFirst()

            for (nextNode in graph.getValue(node)) {
                val nextNodeIndex = nextNode - 1
                if (!visited[nextNodeIndex]) {
                    queue.add(nextNode to cost + 1)
                    costs[nextNodeIndex] = cost + 1
                    visited[nextNodeIndex] = true
                }
            }
        }

        return costs.count { it == costs.maxOf { it } }
    }
}