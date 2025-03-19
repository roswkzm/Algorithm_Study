fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val parenthesis = readLine()!!
        println(if (isCorrectParenthesis(parenthesis)) "YES" else "NO")
    }
}

fun isCorrectParenthesis(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    s.forEach {
        when (it) {
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            '(' -> stack.addLast(it)
            else -> {}
        }
    }
    return stack.isEmpty()
}