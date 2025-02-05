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
        
        while(queue.isNotEmpty()) {
            val (row, col, count) = queue.removeFirst()
            
            if(row to col == endPosition) {
                return count
            }
            
            for((dr, dc) in moveList) {
                var nextRow = row
                var nextCol = col
                
                while(nextRow + dr in board.indices && nextCol + dc in board[0].indices && board[nextRow + dr][nextCol + dc] != 'D') {
                    nextRow += dr
                    nextCol += dc
                }
                
                if(!visited[nextRow][nextCol]) {
                    queue.add(Triple(nextRow, nextCol, count + 1))
                    visited[nextRow][nextCol] = true
                }
            }
        }

        return answer
    }
}