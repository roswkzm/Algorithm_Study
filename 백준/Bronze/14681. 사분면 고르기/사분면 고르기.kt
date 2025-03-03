import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val position = IntArray(2)

    repeat(2) {
        val point = br.readLine().toInt()
        position[it] = point
    }

    if (position[0] > 0 && position[1] > 0) {
        println("1")
    } else if (position[0] < 0 && position[1] > 0) {
        println("2")
    } else if (position[0] < 0 && position[1] < 0) {
        println("3")
    } else if (position[0] > 0 && position[1] < 0) {
        println("4")
    }
}
