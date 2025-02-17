import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (r1, s) = br.readLine().split(" ").map { it.toInt() }

    println(s * 2 - r1)
}
