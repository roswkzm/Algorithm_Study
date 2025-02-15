import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine().toInt()){
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        println("Case #${it + 1}: ${a + b}")
    }
}
