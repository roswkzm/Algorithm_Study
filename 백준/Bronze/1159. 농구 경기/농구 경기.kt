import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nameMap = mutableMapOf<Char, Int>()

    repeat(br.readLine().toInt()) {
        val firstName = br.readLine().first()
        nameMap[firstName] = nameMap.getOrDefault(firstName, 0) + 1
    }

    val result = nameMap.filter { it.value >= 5 }

    if (result.isEmpty()) {
        println("PREDAJA")
    } else {
        println(result.keys.sorted().joinToString(""))
    }
}