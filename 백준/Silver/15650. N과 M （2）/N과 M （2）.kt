fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    fun backtrack(start: Int) {
        if (result.size == m) {
            println(result.joinToString(" "))
            return
        }
        for (i in start..n) {
            result.add(i)
            backtrack(i + 1)
            result.remove(i)
        }
    }

    backtrack(1)
}
