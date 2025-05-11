fun main() {
    val (K, N, A) = readLine()!!.split(" ").map { it.toInt() }

    val alphabet = List(A) { ('A' + it) }
    val sb = StringBuilder()
    var found = false

    fun isValid(): Boolean {
        val s = sb.toString()
        for (len in 1..(s.length / K)) {
            val pattern = s.substring(s.length - len)
            var ok = true
            for (i in 2..K) {
                val start = s.length - len * i
                val end = s.length - len * (i - 1)
                if (start < 0 || s.substring(start, end) != pattern) {
                    ok = false
                    break
                }
            }
            if (ok) return false
        }
        return true
    }

    fun dfs(): Boolean {
        if (sb.length == N) {
            println(sb)
            return true
        }
        for (c in alphabet) {
            sb.append(c)
            if (isValid()) {
                if (dfs()) return true
            }
            sb.deleteCharAt(sb.lastIndex)
        }
        return false
    }

    if (!dfs()) println("-1")
}
