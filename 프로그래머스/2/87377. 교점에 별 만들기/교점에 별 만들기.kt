class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        val points = mutableSetOf<Pair<Int, Int>>()

        // 모든 직선 쌍에 대해 교점 계산
        for (i in line.indices) {
            for (j in i + 1 until line.size) {
                val (A, B, E) = line[i]
                val (C, D, F) = line[j]

                val denominator = (A.toLong() * D - B.toLong() * C)
                if (denominator == 0L) continue // 평행하거나 일치하는 경우

                val xNumerator = (B.toLong() * F - E.toLong() * D)
                val yNumerator = (E.toLong() * C - A.toLong() * F)

                // 정수 좌표인지 확인
                if (xNumerator % denominator == 0L && yNumerator % denominator == 0L) {
                    val x = (xNumerator / denominator).toInt()
                    val y = (yNumerator / denominator).toInt()
                    points.add(Pair(x, y))
                }
            }
        }

        // 최소 및 최대 좌표 계산
        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE

        for ((x, y) in points) {
            if (x < minX) minX = x
            if (x > maxX) maxX = x
            if (y < minY) minY = y
            if (y > maxY) maxY = y
        }

        // 격자판 초기화
        val width = maxX - minX + 1
        val height = maxY - minY + 1
        val grid = Array(height) { CharArray(width) { '.' } }

        // 별 그리기
        for ((x, y) in points) {
            grid[maxY - y][x - minX] = '*'
        }

        // 결과 문자열 배열로 변환
        return grid.map { it.concatToString() }.toTypedArray()
    }
}