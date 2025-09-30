import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().trim()
    val n = s.length
    val m = br.readLine().trim().toInt()

    val r = s.reversed().toCharArray()
    val z = zAlgorithm(r)

    val sb = StringBuilder()
    repeat(m) {
        val i = br.readLine().trim().toInt()
        if (i == n) {
            sb.append(n).append('\n')
        } else {
            val j = n - i
            val ans = if (j == 0) i else minOf(z[j], i)
            sb.append(ans).append('\n')
        }
    }
    print(sb)
}

private fun zAlgorithm(s: CharArray): IntArray {
    val n = s.size
    val z = IntArray(n)
    var l = 0
    var r = 0
    for (i in 1 until n) {
        if (i <= r) z[i] = minOf(r - i + 1, z[i - l])
        while (i + z[i] < n && s[z[i]] == s[i + z[i]]) z[i]++
        if (i + z[i] - 1 > r) {
            l = i
            r = i + z[i] - 1
        }
    }
    return z
}
