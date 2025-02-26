import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { 0 }

    val units = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (t, s) = br.readLine().split(" ").map { it.toInt() }
        units.add(t to s)
    }

    for ((t, s) in units) {
        for (j in k downTo t) {
            dp[j] = maxOf(dp[j], dp[j - t] + s)
        }
    }

    println(dp[k])
}

