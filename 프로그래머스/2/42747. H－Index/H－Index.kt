class Solution {
    fun solution(citations: IntArray): Int {
        for (h in citations.size downTo 1){
            val hCitation = citations.count { it >= h } >= h
            if (hCitation){
                return h
            }
        }
        return 0
    }
}