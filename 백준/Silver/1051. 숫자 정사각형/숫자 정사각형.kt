fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) { readLine()!! }

    var maxSize = 1

    for (i in 0 until n) {
        for (j in 0 until m) {
            val base = board[i][j]
            for (k in 1 until minOf(n, m)) {
                if (i + k < n && j + k < m) {
                    if (board[i][j + k] == base && board[i + k][j] == base && board[i + k][j + k] == base) {
                        maxSize = maxOf(maxSize, (k + 1) * (k + 1))
                    }
                }
            }
        }
    }

    println(maxSize)
}
