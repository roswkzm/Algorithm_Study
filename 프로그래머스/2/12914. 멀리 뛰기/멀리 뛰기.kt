class Solution {
    fun solution(n: Int): Long {
        var answer = LongArray( n + 1 ){ 1 }
        (2..n).forEach{
            answer[it] = (answer[it-2] + answer[it-1]) % 1234567
        }
        return answer[n]
    }
}