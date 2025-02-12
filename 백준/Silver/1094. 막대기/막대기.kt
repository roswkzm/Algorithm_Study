import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val X = br.readLine().toInt()
    val stickList = mutableListOf(64)

    while (stickList.sumOf { it } != X) {
        stickList.sort()

        val sortedHalfStick = stickList.removeFirst() / 2
        stickList.add(sortedHalfStick)
        if (stickList.sumOf { it } < X) {
            stickList.add(sortedHalfStick)
        }
    }

    println(stickList.size)
}