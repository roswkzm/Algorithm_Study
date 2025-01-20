class Solution {
    private var maxDiff = 0
    private var bestShot: IntArray = intArrayOf()

    fun solution(n: Int, info: IntArray): IntArray {
        val ryanShot = IntArray(11) // 라이언의 화살 배치
        dfs(n, 0, info, ryanShot)
        return if (bestShot.isEmpty()) intArrayOf(-1) else bestShot
    }

    private fun dfs(arrows: Int, scoreIdx: Int, apeach: IntArray, ryan: IntArray) {
        if (scoreIdx == 11 || arrows == 0) { // 모든 점수를 계산했거나 화살을 다 쏜 경우
            // 남은 화살을 0점에 추가
            ryan[10] += arrows

            val ryanScore = calculateScore(ryan, apeach)
            val apeachScore = calculateScore(apeach, ryan)
            val diff = ryanScore - apeachScore

            if (diff > 0 && (diff > maxDiff || (diff == maxDiff && isBetterShot(ryan, bestShot)))) {
                maxDiff = diff
                bestShot = ryan.copyOf()
            }
            // 복구
            ryan[10] -= arrows
            return
        }

        // 현재 점수를 라이언이 가져가는 경우
        if (arrows > apeach[scoreIdx]) {
            ryan[scoreIdx] = apeach[scoreIdx] + 1
            dfs(arrows - ryan[scoreIdx], scoreIdx + 1, apeach, ryan)
            ryan[scoreIdx] = 0 // 복구
        }

        // 현재 점수를 포기하고 넘어가는 경우
        dfs(arrows, scoreIdx + 1, apeach, ryan)
    }

    private fun calculateScore(player: IntArray, opponent: IntArray): Int {
        var score = 0
        for (i in player.indices) {
            if (player[i] > opponent[i]) {
                score += 10 - i
            }
        }
        return score
    }

    private fun isBetterShot(current: IntArray, best: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (current[i] != best[i]) {
                return current[i] > best[i]
            }
        }
        return false
    }
}