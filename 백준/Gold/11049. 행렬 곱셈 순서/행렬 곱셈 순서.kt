fun main() {
    val n = readln().toInt()
    val dims = Array(n) { readln().split(" ").map { it.toInt() } }
    val p = IntArray(n + 1)
    for (i in 0 until n) {
        p[i] = dims[i][0]
    }
    p[n] = dims[n - 1][1]

    val dp = Array(n) { LongArray(n) }
    for (len in 2..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            dp[i][j] = Long.MAX_VALUE
            for (k in i until j) {
                val cost = dp[i][k] + dp[k + 1][j] + p[i].toLong() * p[k + 1] * p[j + 1]
                if (cost < dp[i][j]) dp[i][j] = cost
            }
        }
    }
    println(dp[0][n - 1])
}
