class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        val availableWords = arrayOf("aya", "ye", "woo", "ma" )
        val twiceWords = availableWords.map { it + it }

        for (word in babbling) {
            var tempWord = word

            // 중복단어 제거
            for (twiceWord in twiceWords){
                tempWord = tempWord.replace(twiceWord, "X")
            }

            for (availableWord in availableWords) {
                tempWord = tempWord.replace(availableWord, " ")
            }
            // 모든 발음이 제거된 후 빈 문자열이면 발음할 수 있는 단어
            if (tempWord.trim().isEmpty()) {
                answer++
            }
        }
        println(answer)
        return answer
    }
}