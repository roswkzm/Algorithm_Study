class Solution {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { findNextNumber(it) }.toLongArray()
    }

    private fun findNextNumber(x: Long): Long {
        return if (x % 2 == 0L) {
            x + 1
        } else {
            val lowestZeroBit = (x + 1) and -(x + 1)
            x + lowestZeroBit - (lowestZeroBit shr 1)
        }
    }
}