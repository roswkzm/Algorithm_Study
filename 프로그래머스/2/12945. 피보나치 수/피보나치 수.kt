class Solution {
    fun solution(n: Int): Int {
        val answer = arrayListOf(0, 1)
        // 3부터 n까지 반복하며 피보나치 수를 배열에 저장해 줍니다.
        (2..n).forEach{ answer.add((answer[it - 2] + answer[it - 1]) % 1234567) }
        // 배열에 n번 칸에 들어있는 숫자를 반환합니다.
        return answer[n]
    }
}