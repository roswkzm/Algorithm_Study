class Solution {
    fun solution(X: String, Y: String): String {
        val xCount = IntArray(10)
        val yCount = IntArray(10)

        X.forEach { xCount[it - '0']++ }
        Y.forEach { yCount[it - '0']++ }

        val result = StringBuilder()

        for (i in 9 downTo 0) {
            val count = minOf(xCount[i], yCount[i])
            repeat(count) {
                result.append(i)
            }
        }

        return if (result.isEmpty()) {
            "-1"
        } else if (result.toString().matches(Regex("0+"))) {
            "0"
        } else {
            result.toString()
        }
    }
}