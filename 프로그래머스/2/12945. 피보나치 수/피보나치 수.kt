class Solution {
    fun solution(n: Int): Int {
        var answer = arrayListOf(0,1)
        (2..n).forEach{answer.add((answer[it - 1] + answer[it -2]) % 1234567)}
        return answer[n]
    }
}