import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val t = IntArray(n)
    val p = IntArray(n)
    val dp = IntArray(n + 1)

    for(i in 0 until n){
        val (day, cost) = br.readLine().split(" ").map { it.toInt() }
        t[i] = day
        p[i] = cost
    }

    for(i in 0 until n) {
        val nextDay = i + t[i]

        if (i > 0) {
            dp[i] = maxOf(dp[i], dp[i - 1])
        }

        if (nextDay <= n) {
            dp[nextDay] = maxOf(dp[nextDay], dp[i] + p[i])
        }
    }

    println(dp.maxOf { it })
}