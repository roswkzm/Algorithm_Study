class Solution {
    fun solution(storey: Int): Int {
        var answer = 0
        var remainingFloor = storey

        while (remainingFloor > 0) {
            val dight = remainingFloor % 10
            if (dight > 5 || (dight == 5 && (remainingFloor / 10) % 10 >= 5)) {
                answer += 10 - dight
                remainingFloor += 10 - dight
            } else {
                answer += dight
            }
            remainingFloor /= 10
        }
        return answer
    }
}