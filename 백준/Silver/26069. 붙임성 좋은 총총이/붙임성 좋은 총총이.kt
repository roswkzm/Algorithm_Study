import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val danceSet = mutableSetOf("ChongChong")

    repeat(n) {
        val result = br.readLine().split(" ")
        var isDance = false
        for (people in result) {
            if (people in danceSet) {
                isDance = true
            }
        }
        if (isDance) {
            danceSet.addAll(result)
        }
    }

    println(danceSet.size)
}
