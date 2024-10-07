import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        var validCount = 0

        // s의 길이만큼 회전
        for (i in s.indices) {
            val rotatedS = s.substring(i) + s.substring(0, i)
            if (isValid(rotatedS)) {
                validCount++
            }
        }

        return validCount
    }

    // 올바른 괄호 문자열인지 확인하는 함수
    private fun isValid(str: String): Boolean {
        val stack = Stack<Char>()
        for (char in str) {
            when (char) {
                '(', '[', '{' -> stack.push(char)
                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false
                }

                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false
                }

                '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false
                }
            }
        }
        return stack.isEmpty()
    }
}