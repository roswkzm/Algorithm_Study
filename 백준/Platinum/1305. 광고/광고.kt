fun main() {
    val L = readLine()!!.toInt()
    val s = readLine()!!

    val pi = IntArray(L)
    var j = 0
    for (i in 1 until L) {
        while (j > 0 && s[i] != s[j]) {
            j = pi[j - 1]
        }
        if (s[i] == s[j]) {
            j++
            pi[i] = j
        }
    }

    println(L - pi[L - 1])
}