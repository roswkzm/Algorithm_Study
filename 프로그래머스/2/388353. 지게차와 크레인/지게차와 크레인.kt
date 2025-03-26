class Solution {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        val moveList = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
        val board = Array(storage.size + 2) { CharArray(storage[0].length + 2) { '-' } }

        for (row in storage.indices) {
            for (col in storage[0].indices) {
                board[row + 1][col + 1] = storage[row][col]
            }
        }

        fun bfs(requestChar: Char) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            val visited = Array(board.size) { BooleanArray(board[0].size) }
            queue.add(0 to 0)
            visited[0][0] = true

            while (queue.isNotEmpty()) {
                val (currRow, currCol) = queue.removeFirst()

                for ((row, col) in moveList) {
                    val nextRow = currRow + row
                    val nextCol = currCol + col
                    if (nextRow in visited.indices && nextCol in visited[0].indices && !visited[nextRow][nextCol] && board[nextRow][nextCol] == '-') {
                        queue.add(nextRow to nextCol)
                        visited[nextRow][nextCol] = true
                        for ((nRow, nCol) in moveList) {
                            val neighborRow = nextRow + nRow
                            val neighborCol = nextCol + nCol
                            if (neighborRow in visited.indices && neighborCol in visited[0].indices && !visited[neighborRow][neighborCol] && board[neighborRow][neighborCol] == requestChar) {
                                visited[neighborRow][neighborCol] = true
                                board[neighborRow][neighborCol] = '-'
                            }
                        }
                    }
                }
            }
        }

        requests.forEach {
            if (it.length == 1) {
                bfs(it.first())
            } else {
                for (row in 1 until board.size - 1) {
                    for (col in 1 until board[0].size - 1) {
                        if (board[row][col] == it.first()) {
                            board[row][col] = '-'
                        }
                    }
                }
            }
        }

        return board.map { it.count { char -> char != '-' } }.reduce { acc, i -> acc + i }
    }
}