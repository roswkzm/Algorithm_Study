fun main() {
    val (n, m, r) = readLine()!!.split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableList<Int>>()

    repeat(m) {
        val (u, v) = readLine()!!.split(" ").map { it.toInt() }
        map.computeIfAbsent(u) { mutableListOf() }.add(v)
        map.computeIfAbsent(v) { mutableListOf() }.add(u)
    }

    map.values.forEach { it.sortDescending() }

    val visited = mutableSetOf<Int>()
    val result = IntArray(n) { 0 }
    var order = 1

    fun dfs(node: Int) {
        if (node in visited) return
        visited.add(node)
        result[node - 1] = order++

        for (nextNode in map.getOrDefault(node, mutableListOf())) {
            dfs(nextNode)
        }
    }

    dfs(r)

    println(result.joinToString("\n"))
}
