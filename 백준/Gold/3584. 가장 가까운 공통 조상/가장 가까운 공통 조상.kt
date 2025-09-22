fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val parent = IntArray(n + 1)
        val hasParent = BooleanArray(n + 1)
        repeat(n - 1) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            parent[b] = a
            hasParent[b] = true
        }
        val (u, v) = readln().split(" ").map { it.toInt() }

        val visited = BooleanArray(n + 1)
        var x = u
        while (x != 0) {
            visited[x] = true
            x = parent[x]
        }

        var y = v
        var ans = 0
        while (y != 0) {
            if (visited[y]) {
                ans = y
                break
            }
            y = parent[y]
        }
        println(ans)
    }
}