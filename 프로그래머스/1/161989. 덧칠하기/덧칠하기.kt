class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var lastPainted = 0

        for (sectionNumber in section) {
            if (sectionNumber > lastPainted) {
                lastPainted = sectionNumber + m - 1
                answer++
            }
        }

        return answer
    }
}