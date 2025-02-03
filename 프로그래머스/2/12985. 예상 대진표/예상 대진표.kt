class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
 
        var currentA = a
        var currentB = b
        
        while(currentA != currentB) {
            answer++
            currentA = (currentA + 1) / 2
            currentB = (currentB + 1) / 2
        }

        return answer
    }
}