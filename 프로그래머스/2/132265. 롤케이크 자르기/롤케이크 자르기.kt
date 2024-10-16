class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val leftSet = mutableSetOf<Int>()
        val rightMap = mutableMapOf<Int, Int>()

        for (i in topping) {
            rightMap[i] = rightMap.getOrDefault(i, 0) + 1
        }

        for (i in topping.indices) {
            val toppingId = topping[i]

            leftSet.add(toppingId)

            rightMap[toppingId] = rightMap.getValue(toppingId) - 1
            if (rightMap.getValue(toppingId) == 0) {
                rightMap.remove(toppingId)
            }

            if (leftSet.size == rightMap.size) {
                answer++
            }
        }

        return answer
    }
}