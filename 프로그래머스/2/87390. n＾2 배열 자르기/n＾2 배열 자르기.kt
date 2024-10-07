class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val result = IntArray((right - left + 1).toInt())

        // left부터 right까지 필요한 구간만 계산
        for (i in left..right) {
            val row = (i / n).toInt() // i / n 은 행 번호
            val col = (i % n).toInt() // i % n 은 열 번호
            result[(i - left).toInt()] = maxOf(row, col) + 1
        }
        
        return result
    }
}