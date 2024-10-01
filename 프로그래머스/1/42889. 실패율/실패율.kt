class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val stageWithFailureRate = mutableMapOf<Int, Float>()

        for (i in 0 until N) {
            val state = i + 1
            val tryStageCount = stages.count { state <= it }.toFloat()
            val failedStageCount = stages.count { state <= it && it < state + 1 }.toFloat()

            if (tryStageCount == 0f) {
                stageWithFailureRate[state] = 0f
            } else {
                stageWithFailureRate[state] = failedStageCount / tryStageCount
            }
        }
        return stageWithFailureRate.toList().sortedByDescending { it.second }.map { it.first }.toIntArray()
    }
}