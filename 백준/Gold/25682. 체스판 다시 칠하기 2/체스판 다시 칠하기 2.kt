fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln().toCharArray() }

    fun expectedColor(row: Int, col: Int, start: Char): Char {
        return if ((row + col) % 2 == 0) start else if (start == 'B') 'W' else 'B'
    }

    val prefixW = Array(n + 1) { IntArray(m + 1) }
    val prefixB = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (j in 1..m) {
            val c = board[i - 1][j - 1]
            val mismatchW = if (c != expectedColor(i - 1, j - 1, 'W')) 1 else 0
            val mismatchB = if (c != expectedColor(i - 1, j - 1, 'B')) 1 else 0
            prefixW[i][j] = mismatchW + prefixW[i - 1][j] + prefixW[i][j - 1] - prefixW[i - 1][j - 1]
            prefixB[i][j] = mismatchB + prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1]
        }
    }

    var ans = Int.MAX_VALUE
    for (i in k..n) {
        for (j in k..m) {
            val w = prefixW[i][j] - prefixW[i - k][j] - prefixW[i][j - k] + prefixW[i - k][j - k]
            val b = prefixB[i][j] - prefixB[i - k][j] - prefixB[i][j - k] + prefixB[i - k][j - k]
            ans = minOf(ans, minOf(w, b))
        }
    }
    println(ans)
}
