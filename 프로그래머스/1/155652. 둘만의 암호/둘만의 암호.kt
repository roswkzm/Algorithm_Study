class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val skipSet = skip.toList()
        val alphabet = ('a'..'z').filter { it !in skipSet }
        val alphabetSize = alphabet.size
        var answer = StringBuilder()

        for (char in s) {
            val currentIndex = alphabet.indexOf(char)  // 현재 문자의 인덱스를 찾음
            val newIndex = (currentIndex + index) % alphabetSize  // index만큼 이동한 새 인덱스
            answer.append(alphabet[newIndex])  // 새로운 문자 추가
        }

        return answer.toString()
    }
}