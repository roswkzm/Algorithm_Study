class Solution {
    fun solution(n: Int): Long {
        val answer = LongArray(n + 1) { 1 }
        for (i in 2..n) {
            answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567
        }
        return answer[n]
    }
}