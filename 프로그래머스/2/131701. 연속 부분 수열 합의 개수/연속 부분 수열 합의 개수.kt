class Solution {
    fun solution(elements: IntArray): Int {
        val elementsList = elements + elements
        val subSequenceSet = mutableSetOf<Int>()
        
        for(length in 1 .. elements.size) {
            for(startIndex in elements.indices) {
                subSequenceSet.add(elementsList.slice(startIndex until startIndex + length).sum())
            }
        }
        
        return subSequenceSet.count()
    }
}