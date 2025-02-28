import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pie = 3.141592
    val d1 = br.readLine().toInt()
    val d2 = br.readLine().toInt()
    println((2 * d1) + (2 * pie * d2))
}
