import java.util.ArrayList
import java.util.Stack

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val hamburgerArray = arrayListOf(1, 2, 3, 1)

        // 재료들을 보관할 스택 생성
        val ingredientStack = Stack<Int>()
        for (i in ingredient) {
            ingredientStack.push(i)
            // 재료들이 최소 4갱있을 경우만 검사
            if (ingredientStack.size >= 4) {
                // 재료들이 하나씩 들어올때마다 햄버거가 만들어지는지 검사한다.
                // 햄버거가 만들어졌다면 햄버거를 Stack에서 제외하고 다시 검사를 이어간다.
                if (ingredientStack.subList(ingredientStack.size - 4, ingredientStack.size) 
                    == hamburgerArray
                ) {
                    answer++
                    repeat(4) {
                        ingredientStack.pop()
                    }
                }
            }
        }
        return answer
    }
}