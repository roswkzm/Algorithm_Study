data class Edge(val from: Int, val to: Int, val cost: Int)

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()

    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        edges.add(Edge(a, b, c))
    }

    edges.sortBy { it.cost }

    val parent = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a: Int, b: Int): Boolean {
        val rootA = find(a)
        val rootB = find(b)
        if (rootA == rootB) return false
        parent[rootB] = rootA
        return true
    }

    var totalCost = 0
    var maxEdge = 0

    for (edge in edges) {
        if (union(edge.from, edge.to)) {
            totalCost += edge.cost
            maxEdge = edge.cost
        }
    }

    println(totalCost - maxEdge)
}
