class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var addCount = 0

        // 귤 Size를 Key값으로 갖고 개수를 Value로 갖는 Map을 만들자.
        val tangerineCountMap = tangerine.groupBy { it }.map { it.key to it.value.count() }
        val sortList = tangerineCountMap.map { it.second }.sortedDescending()

        for (i in sortList) {
            if (addCount < k) {
                addCount += i
                answer++
            }
        }

        return answer
    }
}