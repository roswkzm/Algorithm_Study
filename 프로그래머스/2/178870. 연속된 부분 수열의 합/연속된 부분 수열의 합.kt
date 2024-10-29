class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var left = 0
        var sum = 0
        var minLength = Int.MAX_VALUE
        var result = intArrayOf(-1, -1)

        for (right in sequence.indices) {
            sum += sequence[right]

            while (sum >= k) {
                if (sum == k) {
                    val currentLength = right - left
                    if (currentLength < minLength) {
                        minLength = currentLength
                        result = intArrayOf(left, right)
                    }
                }
                sum -= sequence[left]
                left++
            }
        }
        return result
    }
}