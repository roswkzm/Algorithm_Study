class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        // 가로는 항상 더 큰 값을 가지도록 정렬
        sizes.forEach { it.sortDescending() }

        // 명함들의 가로 중 최대값과 세로 중 최대값을 찾아 곱하기
        val maxWidth = sizes.maxOf { it[0] }
        val maxHeight = sizes.maxOf { it[1] }

        return maxWidth * maxHeight
    }
}