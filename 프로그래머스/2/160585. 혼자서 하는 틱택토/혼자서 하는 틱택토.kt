class Solution {
    fun solution(board: Array<String>): Int {
        var answer: Int = -1

        fun isWinningGame(player: Char): Boolean {
            for (i in board.indices) {
                if (
                    (board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                ) {
                    return true
                }
            }
            return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[2][0] == player && board[1][1] == player && board[0][2] == player)
        }

        val countO = board.sumOf { row -> row.count { it == 'O' } }
        val countX = board.sumOf { row -> row.count { it == 'X' } }
        if (countX > countO || countO > countX + 1) return 0

        val winO = isWinningGame('O')
        val winX = isWinningGame('X')

        if (winO && winX) return 0
        if (winO && countO != countX + 1) return 0
        if (winX && countO != countX) return 0

        return 1
    }
}