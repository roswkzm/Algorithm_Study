import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()

    val answer = mutableListOf<Int>()
    repeat(2) {
        val result = br.readLine().split(" ").map{ it.toInt() }
        answer.addAll(result)
    }

    println(answer.sorted().joinToString(" "))
}