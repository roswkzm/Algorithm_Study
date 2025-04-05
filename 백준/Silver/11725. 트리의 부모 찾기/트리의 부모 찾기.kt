fun main() {
    val n = readLine()!!.toInt()
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val parent = IntArray(n + 1)
    val visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph.computeIfAbsent(a) { mutableListOf() }.add(b)
        graph.computeIfAbsent(b) { mutableListOf() }.add(a)
    }

    fun dfs(node: Int) {
        visited[node] = true
        for (next in graph.getValue(node)) {
            if (!visited[next]) {
                parent[next] = node
                dfs(next)
            }
        }
    }

    dfs(1)

    for (i in 2..n) {
        println(parent[i])
    }
}