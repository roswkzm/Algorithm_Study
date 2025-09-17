import kotlin.math.min

fun main() {
    val s = readln()
    println(longestPalindromeLength(s))
}

fun longestPalindromeLength(s: String): Int {
    val t = StringBuilder("^")
    for (c in s) {
        t.append("#").append(c)
    }
    t.append("#$")
    val str = t.toString()

    val n = str.length
    val p = IntArray(n)
    var center = 0
    var right = 0
    var maxLen = 0

    for (i in 1 until n - 1) {
        val mirror = 2 * center - i
        if (i < right) {
            p[i] = min(right - i, p[mirror])
        }

        while (str[i + 1 + p[i]] == str[i - 1 - p[i]]) {
            p[i]++
        }

        if (i + p[i] > right) {
            center = i
            right = i + p[i]
        }

        maxLen = maxOf(maxLen, p[i])
    }

    return maxLen
}
