import java.math.BigInteger
import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    println(binomial(n, m))
}

fun binomial(n: Int, m: Int): BigInteger {
    val dp = Array(n + 1) { Array(m + 1) { BigInteger.ZERO } }

    for (i in 0..n) {
        for (j in 0..minOf(i, m)) {
            if (j == 0 || j == i) {
                dp[i][j] = BigInteger.ONE
            } else {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            }
        }
    }

    return dp[n][m]
}
