class Solution {
    fun solution(s: String): IntArray {
        val answer = mutableSetOf<Int>()
        val result = s.substring(2, s.length - 2).split("},{")
            .map { it.split(",").map { it.toInt() } }.sortedBy { it.size }

        for (set in result) {
            for (num in set) {
                answer.add(num)
            }
        }

        return answer.toIntArray()
    }
}
