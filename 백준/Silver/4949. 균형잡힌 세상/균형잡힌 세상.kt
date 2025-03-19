fun main() {
    while (true) {
        val parenthesis = readLine()!!
        if (parenthesis == ".") break
        println(if (isCorrectParenthesis(parenthesis)) "yes" else "no")
    }
}

fun isCorrectParenthesis(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    s.forEach {
        when (it) {
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
            '(', '[' -> stack.addLast(it)
            else -> {}
        }
    }
    return stack.isEmpty()
}