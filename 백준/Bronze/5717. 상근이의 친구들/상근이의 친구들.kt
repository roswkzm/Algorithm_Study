import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val (m, f) = br.readLine().split(" ").map { it.toInt() }
        if (m == 0 && f == 0) break
        println(m + f)
    }
}
