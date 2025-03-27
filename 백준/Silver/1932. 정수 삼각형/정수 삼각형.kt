fun main() {
    val n = readLine()!!.toInt()
    val triangle = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    val dp = Array(n) { IntArray(it + 1) }

    dp[0][0] = triangle[0][0]

    for (i in 1 until n) {
        for (j in 0..i) {
            when (j) {
                0 -> dp[i][j] = dp[i - 1][j] + triangle[i][j]
                i -> dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
                else -> dp[i][j] = maxOf(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
            }
        }
    }

    println(dp[n - 1].maxOf { it })
}