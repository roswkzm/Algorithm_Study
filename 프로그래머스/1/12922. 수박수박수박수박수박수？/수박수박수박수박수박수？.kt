class Solution {
    fun solution(n: Int): String {
        var answer = ""
        val originWord = "수박"
        answer = originWord.repeat(n / 2)
        if (n%2 != 0) answer += originWord.substring(0, 1)
        return answer
    }
}