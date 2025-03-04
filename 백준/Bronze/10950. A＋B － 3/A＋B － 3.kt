import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val resultSum = br.readLine().split(" ").sumOf { it.toInt() }
        println(resultSum)
    }
}