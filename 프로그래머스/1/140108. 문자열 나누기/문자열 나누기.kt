class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var remainderString = s

        while (remainderString.isNotEmpty()){
            val x = remainderString.first()
            var continueCount = 0
            var otherCount = 0
            for ((index, char) in remainderString.withIndex()){
                if (char == x){
                    continueCount++
                } else {
                    otherCount++
                }

                if (continueCount > 0 && continueCount == otherCount){
                    answer++
                    remainderString = remainderString.substring(index + 1)
                    break
                }

                if (index == remainderString.length - 1){
                    answer++
                    remainderString = ""
                }
            }
        }
        return answer
    }
}