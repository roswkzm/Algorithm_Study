class Solution {
    fun solution(food: IntArray): String {
        var answer = "0"
        val foodList = food.mapIndexed { index, i -> mapOf(index to i) }.flatMap { it.toList() }
            .filter { it.second > 1 }
        for (map in foodList.reversed()) {
            val repeatString = map.first.toString().repeat(map.second / 2)
            answer = repeatString + answer + repeatString
        }
        return answer
    }
}