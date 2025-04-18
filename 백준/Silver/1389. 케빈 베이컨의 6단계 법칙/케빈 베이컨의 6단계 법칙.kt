import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val dist = Array(n + 1) { IntArray(n + 1) { 100 } }

    for (i in 1..n) dist[i][i] = 0

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        dist[a][b] = 1
        dist[b][a] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    var minSum = Int.MAX_VALUE
    var person = 0

    for (i in 1..n) {
        val sum = dist[i].sum()
        if (sum < minSum) {
            minSum = sum
            person = i
        }
    }

    println(person)
}
