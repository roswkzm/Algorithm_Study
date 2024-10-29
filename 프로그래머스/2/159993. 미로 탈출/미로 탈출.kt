class Solution {
    fun solution(maps: Array<String>): Int {
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        var startIndex = Pair(0, 0)
        var leverIndex = Pair(0, 0)
        var exitIndex = Pair(0, 0)
        maps.forEachIndexed { row, line ->
            line.forEachIndexed { col, char ->
                when (char) {
                    'S' -> startIndex = row to col
                    'L' -> leverIndex = row to col
                    'E' -> exitIndex = row to col
                }
            }
        }

        fun bfs(start: Pair<Int, Int>, destination: Pair<Int, Int>): Int {
            val queue = ArrayDeque<Triple<Int, Int, Int>>()
            val visited = Array(maps.size) { BooleanArray(maps[0].length) }
            queue.add(Triple(start.first, start.second, 0))
            visited[start.first][start.second] = true

            while (queue.isNotEmpty()) {
                val (row, column, length) = queue.removeFirst()
                if (row == destination.first && column == destination.second) {
                    return length
                }

                for ((dr, dc) in moveList) {
                    val nextRow = row + dr
                    val nextColumn = column + dc
                    if (nextRow in maps.indices && nextColumn in maps[0].indices &&
                        maps[nextRow][nextColumn] != 'X' && !visited[nextRow][nextColumn]) {
                        queue.add(Triple(nextRow, nextColumn, length + 1))
                        visited[nextRow][nextColumn] = true
                    }
                }
            }
            return -1
        }

        val toLever = bfs(startIndex, leverIndex)
        if (toLever == -1) return -1

        val toExit = bfs(leverIndex, exitIndex)
        if (toExit == -1) return -1

        println(toLever)
        println(toExit)

        return toLever + toExit
    }
}