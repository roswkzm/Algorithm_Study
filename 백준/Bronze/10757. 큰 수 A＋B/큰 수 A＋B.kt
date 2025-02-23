import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { BigDecimal(it) }
    println(a + b)
}
