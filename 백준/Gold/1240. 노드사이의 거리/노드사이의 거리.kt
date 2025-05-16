fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (a, b, dist) = readln().split(" ").map { it.toInt() }
        graph[a].add(b to dist)
        graph[b].add(a to dist)
    }

    fun dfs(start: Int, target: Int, visited: BooleanArray, acc: Int): Int {
        if (start == target) return acc
        visited[start] = true
        for ((next, cost) in graph[start]) {
            if (!visited[next]) {
                val result = dfs(next, target, visited, acc + cost)
                if (result != -1) return result
            }
        }
        return -1
    }

    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        val visited = BooleanArray(n + 1)
        println(dfs(from, to, visited, 0))
    }
}
