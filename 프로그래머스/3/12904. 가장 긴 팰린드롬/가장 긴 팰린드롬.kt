class Solution {
    fun solution(s: String): Int {
        var answer = 0

        for (i in s.indices) {
            answer = maxOf(answer, searchPalindromeLength(s, i, i))
            answer = maxOf(answer, searchPalindromeLength(s, i, i + 1))
        }

        return answer
    }

    private fun searchPalindromeLength(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}