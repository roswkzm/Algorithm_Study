import java.util.Stack

class Solution {
    fun solution(number: String, k: Int): String {
        val stack: Stack<Int> = Stack()
        var removeCount = k

        number.forEach {
            val digit = it.digitToInt()

            while (stack.isNotEmpty() && removeCount > 0 && stack.last() < digit) {
                removeCount--
                stack.pop()
            }
            stack.add(digit)
        }


        return stack.take(stack.size - removeCount).joinToString("")
    }
}