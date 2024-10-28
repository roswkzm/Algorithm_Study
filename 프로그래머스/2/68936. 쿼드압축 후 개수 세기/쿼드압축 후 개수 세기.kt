class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf(0, 0)

        fun dp(arr: Array<IntArray>) {
            // 모두 0또는 1이라면 그대로 Return
            val flatArr = arr.flatMap { it.flatMap { listOf(it) } }
            if (flatArr.all { it == 0 }) {
                answer[0] += 1
                return
            }
            if (flatArr.all { it == 1 }) {
                answer[1] += 1
                return
            }

            for (i in 0 until 2) {
                for (j in 0 until 2) {
                    val tempArr = arr.slice((i * arr.size / 2) until ((i + 1) * arr.size / 2))
                        .map {
                            it.slice((j * arr.size / 2) until ((j + 1) * arr.size / 2)).toIntArray()
                        }
                        .toTypedArray()
                    dp(tempArr)
                }
            }
        }

        dp(arr)

        return answer
    }
}