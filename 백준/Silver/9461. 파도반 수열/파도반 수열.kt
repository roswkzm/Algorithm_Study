fun main() {
    val t = readLine()!!.toInt()
    val dp = LongArray(101)

    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2

    for (i in 6..100) {
        dp[i] = dp[i - 1] + dp[i - 5]
    }

    repeat(t) {
        val n = readLine()!!.toInt()
        println(dp[n])
    }
}
