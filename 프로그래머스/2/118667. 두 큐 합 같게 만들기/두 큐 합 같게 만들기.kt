class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val combinedQueue = queue1 + queue2
        val target = (queue1.sum().toLong() + queue2.sum().toLong()) / 2
        var left = 0
        var right = queue1.size
        var currentSum = queue1.sum().toLong()
        val maxMoves = queue1.size * 3  // 이동 횟수 제한
        
        for (moves in 0 until maxMoves) {
            when {
                currentSum == target -> return moves
                currentSum < target -> {
                    currentSum += combinedQueue[right % combinedQueue.size]
                    right++
                }
                else -> {
                    currentSum -= combinedQueue[left % combinedQueue.size]
                    left++
                }
            }
        }
        return -1
    }
}
