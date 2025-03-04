import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val basket = IntArray(n) { it + 1 }
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() - 1 }
        val temp = basket[i]
        basket[i] = basket[j]
        basket[j] = temp
    }
    println(basket.joinToString(" "))
}