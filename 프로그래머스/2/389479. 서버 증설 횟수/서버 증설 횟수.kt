class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0

        val server = IntArray(24)

        players.forEachIndexed { index, i ->
            if (i >= m && server[index] * m < i) {
                val remain = i - server[index] * m
                val new = remain / m
                answer += new
                for (idx in index..minOf(index + k - 1, server.lastIndex)) {
                    server[idx] += new
                }
            }
        }

        return answer
    }
}