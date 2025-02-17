import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    println(numbers.joinToString(" "))
}
