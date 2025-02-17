import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<List<Int>>()

    repeat(3) {
        val result = br.readLine().split(" ").map { it.toInt() }
        list.add(result)
    }

    list.forEach {
        when (it.count { it == 0 }) {
            0 -> println("E")
            1 -> println("A")
            2 -> println("B")
            3 -> println("C")
            4 -> println("D")
        }
    }
}
