class Solution {
    fun solution(p: String): String {

        fun isBalancedString(s: String): Boolean {
            return s.count { it == '(' } == s.count { it == ')' }
        }

        fun isCorrectString(s: String): Boolean {
            val stack = mutableListOf<Char>()
            s.forEach {
                if (it == '(') {
                    stack.add('(')
                } else {
                    if (stack.isEmpty() || stack.removeLast() != '(') return false
                }
            }
            return stack.isEmpty()
        }

        fun transform(s: String): String {
            if (s.isEmpty()) return ""

            var u = ""
            var v = ""
            for (i in 2..s.length step 2) {
                val slice = s.substring(0, i)
                if (isBalancedString(slice)) {
                    u = slice
                    v = s.substring(i)
                    break
                }
            }

            return if (isCorrectString(u)) {
                u + transform(v)
            } else {
                val reversed = u.substring(1, u.length - 1).map { if (it == '(') ')' else '(' }.joinToString("")
                "(${transform(v)})$reversed"
            }
        }

        if (isCorrectString(p)) return p

        return transform(p)
    }
}