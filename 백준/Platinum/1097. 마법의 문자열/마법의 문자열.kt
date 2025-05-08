import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val words = Array(n) { readLine()!! }
    val k = readLine()!!.toInt()
    var count = 0

    fun isMagicWord(s: String): Boolean {
        val l = s.length
        var match = 0
        for (i in 0 until l) {
            var ok = true
            for (j in 0 until l) {
                if (s[(i + j) % l] != s[j]) {
                    ok = false
                    break
                }
            }
            if (ok) match++
        }
        return match == k
    }

    fun permute(a: MutableList<String>, depth: Int) {
        if (depth == a.size) {
            val concat = a.joinToString("")
            if (isMagicWord(concat)) count++
            return
        }
        for (i in depth until a.size) {
            Collections.swap(a, i, depth)
            permute(a, depth + 1)
            Collections.swap(a, i, depth)
        }
    }

    permute(words.toMutableList(), 0)
    println(count)
}
