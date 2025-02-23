import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().map { it }

    val result = s.map {
        when (it) {
            in 'A'..'Z' -> ((it - 'A' + 13) % 26 + 'A'.code).toChar()
            in 'a'..'z' -> ((it - 'a' + 13) % 26 + 'a'.code).toChar()
            else -> it
        }
    }

    println(result.joinToString(""))
}
