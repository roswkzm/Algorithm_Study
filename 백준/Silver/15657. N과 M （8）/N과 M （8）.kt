import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()

    fun backtrack(start: Int, curr: MutableList<Int>) {
        if (curr.size == M) {
            println(curr.joinToString(" "))
            return
        }
        for (i in start until numbers.size) {
            curr.add(numbers[i])
            backtrack(i, curr)
            curr.removeLast()
        }
    }

    backtrack(0, mutableListOf())
}
