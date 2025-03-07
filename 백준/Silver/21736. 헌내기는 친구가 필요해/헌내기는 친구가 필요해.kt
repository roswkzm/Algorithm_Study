fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.toCharArray() }
    var startPosition = 0 to 0
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == 'I') {
                startPosition = i to j
                break
            }
        }
    }

    var result = 0
    val directions = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)

    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(n) { BooleanArray(m) }
    queue.add(startPosition)
    visited[startPosition.first][startPosition.second] = true

    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()
        if (map[row][col] == 'P') {
            result++
        }

        for ((dr, dc) in directions) {
            val nextRow = row + dr
            val nextCol = col + dc
            if (nextRow in map.indices && nextCol in map[0].indices && !visited[nextRow][nextCol] && map[nextRow][nextCol] != 'X') {
                queue.add(nextRow to nextCol)
                visited[nextRow][nextCol] = true
            }
        }
    }

    println(if (result == 0) "TT" else result)
}