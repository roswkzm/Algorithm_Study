import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(N) { 1 }
    val parent = IntArray(N) { -1 }

    for (i in 1 until N) {
        for (j in 0 until i) {
            if (numbers[j] < numbers[i] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                parent[i] = j
            }
        }
    }

    val maxLength = dp.maxOrNull()!!
    val lastIndex = dp.indexOf(maxLength)

    val lis = mutableListOf<Int>()
    var idx = lastIndex
    while (idx != -1) {
        lis.add(numbers[idx])
        idx = parent[idx]
    }

    lis.reverse()

    println(maxLength)
    println(lis.joinToString(" "))
}
