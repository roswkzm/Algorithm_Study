fun main() {
    val n = readLine()!!.toInt()
    val mod = 1_000_000_000
    val dp = Array(n + 1) { LongArray(10) }

    for (i in 1..9) {
        dp[1][i] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            when (j) {
                0 -> dp[i][0] = dp[i - 1][1] % mod
                9 -> dp[i][9] = dp[i - 1][8] % mod
                else -> {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
                }
            }
        }
    }

    val result = dp[n].sum() % mod
    println(result)
}