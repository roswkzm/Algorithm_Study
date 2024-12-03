class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 1
        var right = stones.maxOrNull() ?: 0
        var answer = 0

        fun canCross(stones: IntArray, k: Int, people: Int): Boolean {
            var skipCount = 0

            for (stone in stones) {
                if (stone - people < 0) {
                    skipCount++
                    if (skipCount >= k) return false
                } else {
                    skipCount = 0
                }
            }

            return true
        }

        while (left <= right) {
            val mid = (left + right) / 2
            if (canCross(stones, k, mid)) {
                answer = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return answer
    }
}