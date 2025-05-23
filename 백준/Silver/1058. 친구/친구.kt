fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().toCharArray() }
    var max = 0

    for (i in 0 until n) {
        val visited = BooleanArray(n)
        var count = 0

        for (j in 0 until n) {
            if (i == j) continue
            if (map[i][j] == 'Y') {
                visited[j] = true
                continue
            }
            for (k in 0 until n) {
                if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                    visited[j] = true
                    break
                }
            }
        }
        count = visited.count { it }
        max = max.coerceAtLeast(count)
    }

    println(max)
}
