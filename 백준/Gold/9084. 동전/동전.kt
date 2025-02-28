import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val coins = br.readLine().split(" ").map { it.toInt() }
        val m = br.readLine().toInt()

        val dp = IntArray(m + 1) { 0 }
        dp[0] = 1

        for (coin in coins) {
            for (j in coin..m) {
                dp[j] += dp[j - coin]
            }
        }

        println(dp[m])
    }
}
