class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        val boxCount = score.size / m
        val sortedScore = score.sortedDescending()
        val boxWithApple = mutableListOf<List<Int>>()

        for (i in 0 until boxCount) {
            val startIndex = i * m
            boxWithApple.add(sortedScore.subList(startIndex, startIndex + m))
        }
        return boxWithApple.sumOf { (it.minOrNull() ?: 0) * m }
    }
}