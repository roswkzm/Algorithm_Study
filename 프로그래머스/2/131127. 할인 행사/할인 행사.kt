class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantCountMap = want.mapIndexed { index, s -> s to number[index] }.toMap()

        for (startIndex in 0..discount.size - number.sum()) {
            val saleList = discount.slice(startIndex until startIndex + number.sum())

            val myList = wantCountMap.toMutableMap()

            saleList.forEach {
                if (myList.keys.contains(it)) {
                    myList[it] = myList.getValue(it) - 1
                }
            }

            if (myList.values.all { it == 0 }) answer++
        }

        return answer
    }
}