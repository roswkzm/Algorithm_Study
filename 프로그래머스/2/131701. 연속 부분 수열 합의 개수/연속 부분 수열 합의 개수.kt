class Solution {
    fun solution(elements: IntArray): Int {
        val circleElements = elements + elements
        val result = mutableSetOf<Int>()

        for (i in 1..elements.size) {
            for (startIndex in elements.indices) {
                result.add(circleElements.slice(startIndex until startIndex + i).sum())
            }
        }

        return result.size
    }
}