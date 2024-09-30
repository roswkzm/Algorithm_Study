class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        answer = n.toString(3).reversed().toInt(3)
        return answer
    }
}