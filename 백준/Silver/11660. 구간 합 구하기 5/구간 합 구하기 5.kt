import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(n + 1) { IntArray(n + 1) }
    val prefixSum = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            array[i][j] = row[j - 1]
            prefixSum[i][j] = array[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
        }
    }
    repeat(m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        val result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1]
        println(result)
    }
}
