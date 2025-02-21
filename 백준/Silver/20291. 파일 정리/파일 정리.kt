import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val result = br.readLine().substringAfter('.')
        map[result] = map.getOrDefault(result, 0) + 1
    }
    map.toList().sortedBy { it.first }.forEach {
        println("${it.first} ${it.second}")
    }
}
