fun main() {
    val t = readln().toInt()
    val dp = Array(41) { IntArray(2) }

    dp[0][0] = 1
    dp[0][1] = 0
    dp[1][0] = 0
    dp[1][1] = 1

    for (i in 2..40) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1]
    }

    repeat(t) {
        val n = readln().toInt()
        println("${dp[n][0]} ${dp[n][1]}")
    }
}
