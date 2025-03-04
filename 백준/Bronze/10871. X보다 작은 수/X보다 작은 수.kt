import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    println(list.filter { it < x }.joinToString(" "))
}