class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        // arr1의 행의 수와 arr2의 열의 수로 결과 배열 초기화
        val rows = arr1.size
        val cols = arr2[0].size
        val answer = Array(rows) { IntArray(cols) }

        // 행렬 곱셈 진행
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                var sum = 0
                // arr1의 열과 arr2의 행 길이는 동일해야 함
                for (k in arr1[0].indices) {
                    sum += arr1[i][k] * arr2[k][j]
                }
                answer[i][j] = sum
            }
        }
        return answer
    }
}
