class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var tournamentNumberA = a
        var tournamentNumberB = b

        while (tournamentNumberA != tournamentNumberB) {
            tournamentNumberA = (tournamentNumberA + 1) / 2
            tournamentNumberB = (tournamentNumberB + 1) / 2
            answer++
        }
        return answer
    }
}