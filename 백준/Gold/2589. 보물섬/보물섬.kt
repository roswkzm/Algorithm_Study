fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.toCharArray() }
    val directions = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
    var maxDistance = 0

    fun bfs(startX: Int, startY: Int): Int {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = Array(n) { BooleanArray(m) }
        var maxDist = 0

        queue.add(Triple(startX, startY, 0))
        visited[startX][startY] = true

        while (queue.isNotEmpty()) {
            val (x, y, dist) = queue.removeFirst()
            maxDist = maxOf(maxDist, dist)

            for ((dx, dy) in directions) {
                val nextX = x + dx
                val nextY = y + dy
                if (nextX in map.indices && nextY in map[0].indices && !visited[nextX][nextY] && map[nextX][nextY] == 'L') {
                    queue.add(Triple(nextX, nextY, dist + 1))
                    visited[nextX][nextY] = true
                }
            }
        }
        return maxDist
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'L') {
                maxDistance = maxOf(maxDistance, bfs(i, j))
            }
        }
    }

    println(maxDistance)
}