import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<Int>()

    repeat(br.readLine().toInt()) {
        list.add(br.readLine().toInt())
    }

    list.sorted().forEach { println(it) }
}