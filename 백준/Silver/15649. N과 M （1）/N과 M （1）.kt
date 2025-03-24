fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    val visited = BooleanArray(n + 1)

    fun backtrack() {
        if (result.size == m) {
            println(result.joinToString(" "))
            return
        }
        for (i in 1..n) {
            if (!visited[i]) {
                visited[i] = true
                result.add(i)
                backtrack()
                result.removeAt(result.size - 1)
                visited[i] = false
            }
        }
    }

    backtrack()
}