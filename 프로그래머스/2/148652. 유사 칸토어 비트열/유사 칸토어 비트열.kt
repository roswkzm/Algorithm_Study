class Solution {
    fun solution(n: Int, l: Long, r: Long): Int {
        fun countOnes(n: Int, start: Long, end: Long, l: Long, r: Long): Int {
            if (n == 0) return 1

            val segmentLength = Math.pow(5.0, (n - 1).toDouble()).toLong()

            val seg1 = start until (start + segmentLength)
            val seg2 = (start + segmentLength) until (start + 2 * segmentLength)
            val seg3 = (start + 2 * segmentLength) until (start + 3 * segmentLength)
            val seg4 = (start + 3 * segmentLength) until (start + 4 * segmentLength)
            val seg5 = (start + 4 * segmentLength) until (start + 5 * segmentLength)

            var count = 0

            if (l <= seg1.last && r >= seg1.first) {
                count += countOnes(n - 1, seg1.first, seg1.last, maxOf(l, seg1.first), minOf(r, seg1.last))
            }

            if (l <= seg2.last && r >= seg2.first) {
                count += countOnes(n - 1, seg2.first, seg2.last, maxOf(l, seg2.first), minOf(r, seg2.last))
            }

            if (l <= seg4.last && r >= seg4.first) {
                count += countOnes(n - 1, seg4.first, seg4.last, maxOf(l, seg4.first), minOf(r, seg4.last))
            }

            if (l <= seg5.last && r >= seg5.first) {
                count += countOnes(n - 1, seg5.first, seg5.last, maxOf(l, seg5.first), minOf(r, seg5.last))
            }

            return count
        }

        return countOnes(n, 1, Math.pow(5.0, n.toDouble()).toLong(), l, r)
    }
}