class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = want.mapIndexed { index, s -> s to number[index] }.toMap()
        println(wantMap)

        for (i in 0..discount.size - number.sum()) {
            val saleList = discount.slice(i until i + number.sum())
            val myList = wantMap.toMutableMap()

            for (item in saleList){
                if (myList.containsKey(item)){
                    myList[item] = myList.getValue(item) - 1
                }
            }

            if (myList.values.all { it == 0 }) answer++
        }

        return answer
    }
}