class Solution {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        var startIndex = Pair(0, 0)
        var leverIndex = Pair(0, 0)
        var endIndex = Pair(0, 0)

        maps.forEachIndexed { rowIndex, s ->
            s.forEachIndexed { colIndex, c ->
                when (c) {
                    'S' -> startIndex = rowIndex to colIndex
                    'L' -> leverIndex = rowIndex to colIndex
                    'E' -> endIndex = rowIndex to colIndex
                }
            }
        }

        fun bfs(origin: Pair<Int, Int>, destination: Pair<Int, Int>): Int? {
            val queue = ArrayDeque<Triple<Int, Int, Int>>()
            val visited = Array(maps.size) { BooleanArray(maps[0].length) }
            queue.add(Triple(origin.first, origin.second, 0))
            visited[origin.first][origin.second] = true

            while (queue.isNotEmpty()) {
                val (row, column, time) = queue.removeFirst()
                if (destination == row to column) {
                    return time
                }

                for ((dr, dc) in moveList) {
                    val nextRow = row + dr
                    val nextColumn = column + dc
                    if (nextRow in maps.indices && nextColumn in maps[0].indices && maps[nextRow][nextColumn] != 'X' && !visited[nextRow][nextColumn]) {
                        queue.add(Triple(nextRow, nextColumn, time + 1))
                        visited[nextRow][nextColumn] = true
                    }
                }
            }
            return null
        }

        answer += bfs(startIndex, leverIndex) ?: return -1
        answer += bfs(leverIndex, endIndex) ?: return -1

        return answer
    }
}