class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        val roadMap = mutableMapOf<Int, MutableList<Int>>()
        roads.forEach {
            val startSource = it[0]
            val endSource = it[1]

            roadMap.computeIfAbsent(startSource) { mutableListOf() }.add(endSource)
            roadMap.computeIfAbsent(endSource) { mutableListOf() }.add(startSource)
        }

        val distances = IntArray(n + 1) { -1 }
        val queue = ArrayDeque<Int>()
        queue.add(destination)
        distances[destination] = 0

        while (queue.isNotEmpty()) {
            val curSource = queue.removeFirst()
            val curDistances = distances[curSource]

            for (nextSource in roadMap.getOrDefault(curSource, mutableListOf())) {
                if (distances[nextSource] == -1) {
                    queue.add(nextSource)
                    distances[nextSource] = curDistances + 1
                }
            }
        }

        return sources.map { distances[it] }.toIntArray()
    }
}