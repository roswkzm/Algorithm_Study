import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val students = Array(2) { IntArray(7) }
    var result = 0

    repeat(n) {
        val (s, y) = br.readLine().split(" ").map { it.toInt() }
        students[s][y]++
    }

    for (gender in 0..1) {
        for (grade in 1..6) {
            val count = students[gender][grade]
            if (count > 0) {
                result += (count + k - 1) / k
            }
        }
    }

    println(result)
}