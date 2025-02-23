import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    fun dp(n : Int) : Int {
        if (n == 1) return 2
        return dp(n - 1) + dp(n - 1)
    }

    println(dp(n))
}
