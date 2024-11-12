class Solution {
    fun solution(n: Int): IntArray {
        // 2차원 배열 생성
        val triangle = Array(n) { IntArray(it + 1) }

        var num = 1 // 채워질 값
        var x = -1 // 시작 위치의 x 좌표
        var y = 0 // 시작 위치의 y 좌표

        // n부터 1까지 반복하며 각 방향으로 채우기
        for (i in 0 until n) {
            for (j in i until n) {
                when (i % 3) {
                    0 -> {
                        x++ // 아래로 이동
                    }
                    1 -> {
                        y++     // 오른쪽으로 이동
                    }
                    2 -> {
                        x--
                        y--
                    } // 대각선 위로 이동
                }
                triangle[x][y] = num++
            }
        }

        // 2차원 배열을 1차원 배열로 변환
        val result = mutableListOf<Int>()
        for (row in triangle) {
            for (value in row) {
                result.add(value)
            }
        }

        return result.toIntArray()
    }
}