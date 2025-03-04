import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val result = (1..n).toList().reduce { acc, i -> acc + i }
    println(result)
}