fun main() {
    val n = readLine()!!.toInt()
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    repeat(n) {
        val tree = readLine()!!.split(" ").map { it.toInt() }
        val node = tree[0]
        for (i in 1 until tree.size step 2) {
            if (tree[i] == -1) break
            graph.getOrPut(node) { mutableListOf() }.add(tree[i] to tree[i + 1])
        }
    }

    // DFS 함수 정의
    fun dfs(start: Int): Pair<Int, Int> {
        val visited = BooleanArray(n + 1)
        var farthestNode = start
        var maxDist = 0

        fun go(cur: Int, dist: Int) {
            visited[cur] = true
            if (dist > maxDist) {
                maxDist = dist
                farthestNode = cur
            }

            for ((next, cost) in graph[cur].orEmpty()) {
                if (!visited[next]) {
                    go(next, dist + cost)
                }
            }
        }

        go(start, 0)
        return farthestNode to maxDist
    }

    val (farthestNode, _) = dfs(1)

    val (_, diameter) = dfs(farthestNode)

    println(diameter)
}