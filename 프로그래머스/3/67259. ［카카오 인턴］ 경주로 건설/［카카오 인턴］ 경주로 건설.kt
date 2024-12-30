class Solution {
    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        val costs = Array(n) { Array(n) { IntArray(4) { Int.MAX_VALUE } } }

        val queue: ArrayDeque<Triple<Int, Int, Int>> = ArrayDeque()
        for (i in 0..3) {
            costs[0][0][i] = 0
        }
        queue.add(Triple(0, 0, -1))

        while (queue.isNotEmpty()) {
            val (x, y, prevDir) = queue.removeFirst()

            for (nextDir in directions.indices) {
                val nx = x + directions[nextDir].first
                val ny = y + directions[nextDir].second

                if (nx in 0 until n && ny in 0 until n && board[nx][ny] == 0) {
                    var newCost = costs[x][y][prevDir.coerceAtLeast(0)] + 100
                    if (prevDir != -1 && prevDir != nextDir) {
                        newCost += 500
                    }

                    if (newCost < costs[nx][ny][nextDir]) {
                        costs[nx][ny][nextDir] = newCost
                        queue.add(Triple(nx, ny, nextDir))
                    }
                }
            }
        }

        return costs[n - 1][n - 1].minOrNull() ?: Int.MAX_VALUE
    }
}