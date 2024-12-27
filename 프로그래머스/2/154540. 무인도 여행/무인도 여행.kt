class Solution {
    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        fun bfs(startDestination: Pair<Int, Int>): Int {
            var totalSize = maps[startDestination.first][startDestination.second].digitToInt()
            val queue = ArrayDeque<Pair<Int, Int>>()
            visited[startDestination.first][startDestination.second] = true
            queue.add(startDestination)

            while (queue.isNotEmpty()) {
                val (row, column) = queue.removeFirst()

                for ((dr, dc) in moveList) {
                    val nextRow = row + dr
                    val nextColumn = column + dc
                    if (nextRow in maps.indices && nextColumn in maps[0].indices && maps[nextRow][nextColumn] != 'X' && !visited[nextRow][nextColumn]) {
                        visited[nextRow][nextColumn] = true
                        queue.add(nextRow to nextColumn)
                        totalSize += maps[nextRow][nextColumn].digitToInt()
                    }
                }
            }
            return totalSize
        }

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i to j))
                }
            }
        }

        return if (answer.isEmpty()) IntArray(1) { -1 } else answer.sorted().toIntArray()
    }
}