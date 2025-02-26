import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var maxPrice = 0

    repeat(n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        val price = when {
            a == b && b == c -> {
                10000 + a * 1000
            }
            a == b || a == c -> {
                1000 + a * 100
            }
            b == c -> {
                1000 + b * 100
            }
            else -> {
                maxOf(a, b, c) * 100
            }
        }
        maxPrice = maxOf(price, maxPrice)
    }
    println(maxPrice)
}