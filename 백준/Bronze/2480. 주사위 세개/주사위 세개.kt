import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    val result = when {
        a == b && b == c -> a * 1000 + 10000
        a == b || b == c -> b * 100 + 1000
        a == c -> a * 100 + 1000
        else -> maxOf(a, b, c) * 100
    }
    println(result)
}