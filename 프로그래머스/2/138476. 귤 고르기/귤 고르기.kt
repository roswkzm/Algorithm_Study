class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var currentTangerine = 0
        
        val tangerineSortCount = tangerine.groupBy{ it }.map{ it.key to it.value.count() }
        .map { it.second }.sortedDescending()
        
        for(i in tangerineSortCount){
            if(currentTangerine < k){
                answer++
                currentTangerine += i
            }
        }
        
        return answer
    }
}