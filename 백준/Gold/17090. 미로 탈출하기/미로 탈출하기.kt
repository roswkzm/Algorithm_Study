import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    val board = Array(r) { br.readLine().toCharArray() }
    val visited = Array(r) { BooleanArray(c) }
    val cache = Array(r) { BooleanArray(c) }
    var result = 0

    fun dfs(row: Int, col: Int): Boolean {
        if (row !in 0 until r || col !in 0 until c) return true
        if (visited[row][col]) return cache[row][col]

        visited[row][col] = true
        val (dr, dc) = getDirection(board[row][col])
        val nextRow = row + dr
        val nextCol = col + dc

        cache[row][col] = dfs(nextRow, nextCol)
        return cache[row][col]
    }

    for (row in 0 until r) {
        for (col in 0 until c) {
            if (dfs(row, col)) result++
        }
    }

    println(result)
}

fun getDirection(c: Char): Pair<Int, Int> {
    return when (c) {
        'U' -> -1 to 0
        'R' -> 0 to 1
        'D' -> 1 to 0
        'L' -> 0 to -1
        else -> 0 to 0
    }
}
