fun main() {
    val t = readLine()!!.toInt()
    val dp = Array(31) { IntArray(31) }

    for (i in 0..30) {
        dp[i][0] = 1
        dp[i][i] = 1
    }

    for (i in 1..30) {
        for (j in 1 until i) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }

    repeat(t) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        println(dp[m][n])
    }
}