class Solution {
    fun solution(edges: Array<IntArray>): Array<Int> {
        var graph = Array<MutableList<Int>>(1000001) { mutableListOf() }
        var answer = arrayOf(0, 0, 0, 0)
        var inN = Array(1000001) { 0 }
        var outN = Array(1000001) { 0 }

        fun bfs(graph: Array<MutableList<Int>>, start: Int): Int {
            val q = ArrayDeque<Int>()
            var n = 0

            q.add(start)

            while (q.isNotEmpty()) {
                val p = q.removeFirst()
                n++

                if (n > 1 && p == start) {
                    return 1
                }

                graph[p].forEach {
                    if (graph[it].size > 1) {
                        return 3
                    }

                    q.add(it)
                }
            }

            return 2
        }

        edges.forEach { (start, end) ->
            inN[end]++
            outN[start]++

            graph[start].add(end)
        }

        for (i in 0 until 1000001) {
            if (inN[i] == 0 && outN[i] > 1) {
                answer[0] = i

                break
            }
        }

        graph[answer[0]].forEach {
            answer[bfs(graph, it)]++
        }

        return answer
    }
}