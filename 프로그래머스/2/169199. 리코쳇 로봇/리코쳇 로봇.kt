class Solution {
    fun solution(board: Array<String>): Int {
        var answer: Int = -1
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
            val (row, column, length) = queue.removeFirst()
            if (row == endPosition.first && column == endPosition.second) {
                return length
            }

            for ((dr, dc) in moveList) {
                var curRow = row
                var curCol = column
                while (curRow + dr in board.indices && curCol + dc in board[0].indices && board[curRow + dr][curCol + dc] != 'D') {
                    curRow += dr
                    curCol += dc
                }
                if (!visited[curRow][curCol]) {
                    queue.add(Triple(curRow, curCol, length + 1))
                    visited[curRow][curCol] = true
                }
            }
        }

        return answer
    }
}