class Solution {
    fun solution(s: String, n: Int): String {
        return s.map { char ->
            when {
                char.isUpperCase() -> {
                    // 대문자 처리 (A~Z 순환)
                    ((char - 'A' + n) % 26 + 'A'.code).toChar()
                }
                char.isLowerCase() -> {
                    // 소문자 처리 (a~z 순환)
                    ((char - 'a' + n) % 26 + 'a'.code).toChar()
                }
                else -> {
                    // 공백은 그대로
                    char
                }
            }
        }.joinToString("")
    }
}
