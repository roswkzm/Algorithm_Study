class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        // 1. 의상 종류별로 의상 수를 카운트한다
        val clothesMap = clothes.groupBy({ it[1] }, { it[0] })

        println(clothesMap)

        // 2. 의상 수에 1을 더한 후 곱한다 (입지 않는 경우를 포함)
        val combinations = clothesMap.values.fold(1) { acc, clothList ->
            acc * (clothList.size + 1)
        }
        println(combinations)

        // 3. 아무것도 입지 않는 경우를 제외하고 반환
        return combinations - 1
    }
}