class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var left = 1
        var right = diffs.maxOf { it }
        var answer = right
        val diffsArray = diffs.map { it.toLong() }
        val timesArray = times.map { it.toLong() }

        fun canSolveGame(level: Int): Boolean {
            var totalTime = 0L
            var prevTime = 0L

            for (currIndex in timesArray.indices) {
                val diff = diffsArray[currIndex]
                val time = timesArray[currIndex]

                if (diff <= level) {
                    totalTime += time
                } else {
                    val repeatTime = diff - level
                    totalTime += (prevTime + time) * repeatTime + time
                }

                if (totalTime > limit) return false
                prevTime = time
            }
            return true
        }

        while (left <= right) {
            val mid = (left + right) / 2

            if (canSolveGame(mid)) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return answer
    }
}