class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val n = board.size
        val m = board[0].size
        val prefixSum = Array(n + 1) { IntArray(m + 1) }

        // 누적합 배열에 스킬 적용
        for (s in skill) {
            val type = s[0]
            val r1 = s[1]
            val c1 = s[2]
            val r2 = s[3]
            val c2 = s[4]
            val degree = if (type == 1) -s[5] else s[5]

            prefixSum[r1][c1] += degree
            prefixSum[r1][c2 + 1] -= degree
            prefixSum[r2 + 1][c1] -= degree
            prefixSum[r2 + 1][c2 + 1] += degree
        }

        // 누적합 계산
        for (i in 0 until n) {
            for (j in 1 until m) {
                prefixSum[i][j] += prefixSum[i][j - 1]
            }
        }

        for (j in 0 until m) {
            for (i in 1 until n) {
                prefixSum[i][j] += prefixSum[i - 1][j]
            }
        }

        // board에 누적합 반영 후 파괴되지 않은 건물 개수 계산
        var intactCount = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] += prefixSum[i][j]
                if (board[i][j] > 0) {
                    intactCount++
                }
            }
        }

        return intactCount
    }
}