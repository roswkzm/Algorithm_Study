class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        // 1. 행렬 초기화
        val matrix = Array(rows) { i -> IntArray(columns) { j -> i * columns + j + 1 } }
        val answer = mutableListOf<Int>()

        // 2. 각 쿼리를 처리
        for (query in queries) {
            // rotateEdge 함수를 통해 각 쿼리에 대한 회전을 처리하고, 최솟값을 저장
            answer.add(rotateEdge(matrix, query))
        }

        return answer.toIntArray()
    }

    // 테두리를 시계 방향으로 회전시키고, 이동된 숫자 중 최솟값을 반환하는 함수
    private fun rotateEdge(matrix: Array<IntArray>, query: IntArray): Int {
        val (x1, y1, x2, y2) = query.map { it - 1 }  // 0 기반 인덱스로 맞춤
        var minValue = Int.MAX_VALUE  // 최솟값 저장용
        var temp = matrix[x1][y1]  // 첫 위치 값 저장

        // 왼쪽 열 (위에서 아래로)
        for (i in x1 until x2) {
            matrix[i][y1] = matrix[i + 1][y1]
            minValue = minOf(minValue, matrix[i][y1])
        }

        // 아래쪽 행 (왼쪽에서 오른쪽으로)
        for (j in y1 until y2) {
            matrix[x2][j] = matrix[x2][j + 1]
            minValue = minOf(minValue, matrix[x2][j])
        }

        // 오른쪽 열 (아래에서 위로)
        for (i in x2 downTo x1 + 1) {
            matrix[i][y2] = matrix[i - 1][y2]
            minValue = minOf(minValue, matrix[i][y2])
        }

        // 위쪽 행 (오른쪽에서 왼쪽으로)
        for (j in y2 downTo y1 + 1) {
            matrix[x1][j] = matrix[x1][j - 1]
            minValue = minOf(minValue, matrix[x1][j])
        }

        // 마지막으로 회전이 완료된 위치에 temp 값을 삽입
        matrix[x1][y1 + 1] = temp
        minValue = minOf(minValue, temp)

        return minValue
    }
}
