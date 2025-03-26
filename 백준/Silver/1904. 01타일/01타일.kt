fun main() {
    val n = readLine()!!.toInt()
    val mod = 15746

    if (n == 1) {
        println(1)
        return
    }
    if (n == 2) {
        println(2)
        return
    }

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % mod
    }

    println(dp[n])
}