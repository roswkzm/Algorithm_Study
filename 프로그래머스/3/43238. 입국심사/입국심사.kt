class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var left = 1L
        var right = times.maxOf { it.toLong() } * n
        var answer = right

        while (left <= right) {
            val mid = (left + right) / 2

            val totalPeople = times.fold(0L) { acc, time -> acc + mid / time }

            if (totalPeople >= n) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return answer
    }
}