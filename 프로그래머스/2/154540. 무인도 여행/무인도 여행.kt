class Solution {
    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        fun bfs(startIndex: Pair<Int, Int>) : Int {
            var foodCount = maps[startIndex.first][startIndex.second].digitToInt()
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(startIndex)
            visited[startIndex.first][startIndex.second] = true

            while (queue.isNotEmpty()) {
                val (row, column) = queue.removeFirst()

                for ((dr, dc) in moveList) {
                    val nextRow = row + dr
                    val nextColumn = column + dc
                    if (nextRow in maps.indices && nextColumn in maps[0].indices && !visited[nextRow][nextColumn]) {
                        if (maps[nextRow][nextColumn] != 'X') {
                            queue.add(nextRow to nextColumn)
                            visited[nextRow][nextColumn] = true
                            foodCount += maps[nextRow][nextColumn].digitToInt()
                        }
                    }
                }
            }
            return foodCount
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