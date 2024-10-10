class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = mutableListOf<Int>()

        for (i in numbers.indices) {
            while (stack.isNotEmpty() && numbers[stack.last()] < numbers[i]) {
                answer[stack.removeAt(stack.size - 1)] = numbers[i]
            }
            stack.add(i)
        }

        return answer
    }
}