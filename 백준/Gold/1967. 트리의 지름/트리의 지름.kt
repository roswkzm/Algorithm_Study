fun main() {
    val n = readLine()!!.toInt()
    val tree = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (parent, child, weight) = readLine()!!.split(" ").map { it.toInt() }
        tree[parent].add(child to weight)
        tree[child].add(parent to weight)
    }

    var visited = BooleanArray(n + 1)
    var maxDist = 0
    var farthestNode = 1

    fun dfs(node: Int, dist: Int) {
        if (dist > maxDist) {
            maxDist = dist
            farthestNode = node
        }
        for ((next, weight) in tree[node]) {
            if (!visited[next]) {
                visited[next] = true
                dfs(next, dist + weight)
            }
        }
    }

    visited[1] = true
    dfs(1, 0)

    visited = BooleanArray(n + 1)
    maxDist = 0
    visited[farthestNode] = true
    dfs(farthestNode, 0)

    println(maxDist)
}
