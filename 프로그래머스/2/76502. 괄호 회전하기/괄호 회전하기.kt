import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        for(i in s.indices){
            val rotateS = s.substring(i) + s.substring(0, i)
            if(isCorrect(rotateS)) answer++
        }
        
        return answer
    }
    
    private fun isCorrect(s : String) : Boolean {
        val stack = Stack<Char>()
        
        for(c in s){
            when(c) {
                '[', '(', '{' -> {
                    stack.add(c)
                }
                ']' -> {
                    if(stack.isEmpty() || stack.pop() != '[') return false
                }
                ')' -> {
                    if(stack.isEmpty() || stack.pop() != '(') return false
                }
                '}' -> {
                    if(stack.isEmpty() || stack.pop() != '{') return false
                }
            }
        }
        return stack.isEmpty()
    }
}