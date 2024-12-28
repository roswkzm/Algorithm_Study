class Solution {
    fun solution(board: Array<String>): Int {
        val answer: Int = -1
        var startPosition = -1 to -1
        var endPosition = -1 to -1
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val visited = Array(board.size) { BooleanArray(board[0].length) }

        board.forEachIndexed { index, s ->
            if (s.contains('R')) {
                startPosition = index to s.indexOf('R')
            }
            if (s.contains('G')) {
                endPosition = index to s.indexOf('G')
            }
        }

        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        queue.add(Triple(startPosition.first, startPosition.second, 0))
        visited[startPosition.first][startPosition.second] = true

        while (queue.isNotEmpty()) {
            val (row, column, moveCount) = queue.removeFirst()

            if (row to column == endPosition) {
                return moveCount
            }

            for ((dr, dc) in moveList) {
                var nextRow = row
                var nextColumn = column
                while (nextRow + dr in board.indices && nextColumn + dc in board[0].indices && board[nextRow + dr][nextColumn + dc] != 'D') {
                    nextRow += dr
                    nextColumn += dc
                }
                if (!visited[nextRow][nextColumn]) {
                    queue.add(Triple(nextRow, nextColumn, moveCount + 1))
                    visited[nextRow][nextColumn] = true
                }
            }
        }

        return answer
    }
}