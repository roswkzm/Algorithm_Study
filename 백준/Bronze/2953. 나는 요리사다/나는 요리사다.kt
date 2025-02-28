import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val score = IntArray(5)

    repeat(5) {
        val result = br.readLine().split(" ").map { it.toInt() }.sumOf { it }
        score[it] = result
    }

    println("${score.indexOf(score.maxOf { it }) + 1} ${score.maxOf { it }}")
}
