class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        val col = IntArray(n) // 각 행에 있는 퀸의 열 위치를 저장하는 배열

        fun isSafe(row: Int): Boolean {
            for (i in 0 until row) {
                // 같은 열에 있는지 또는 대각선에 있는지 확인
                if (col[i] == col[row] || Math.abs(col[row] - col[i]) == row - i) {
                    return false
                }
            }
            return true
        }

        fun dfs(row: Int) {
            if (row == n) {
                answer++
                return
            }
            for (c in 0 until n) {
                col[row] = c
                if (isSafe(row)) {
                    dfs(row + 1)
                }
            }
        }

        dfs(0)
        return answer
    }
}