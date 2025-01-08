class Solution {
    fun solution(k: Int, d: Int): Long {
        var count: Long = 0

        var x = 0
        while (x <= d) {
            val maxY = Math.sqrt((d.toLong() * d - x.toLong() * x).toDouble()).toLong()
            count += (maxY / k) + 1
            x += k
        }

        return count
    }
}