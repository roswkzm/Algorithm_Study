class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = "Yes"

        val card1Copy = cards1.toMutableList()
        val card2Copy = cards2.toMutableList()

        for (word in goal) {
            if (word == card1Copy.firstOrNull()) {
                card1Copy.removeFirst()
                continue
            }
            if (word == card2Copy.firstOrNull()) {
                card2Copy.removeFirst()
                continue
            }
            answer = "No"
            return answer
        }
        return answer
    }
}