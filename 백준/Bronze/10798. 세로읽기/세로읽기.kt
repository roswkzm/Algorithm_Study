import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val words = Array(5) { br.readLine()!! }
    val maxLen = words.maxOf { it.length }
    val sb = StringBuilder()
    for (i in 0 until maxLen) {
        for (w in words) {
            if (i < w.length) sb.append(w[i])
        }
    }
    println(sb)
}
