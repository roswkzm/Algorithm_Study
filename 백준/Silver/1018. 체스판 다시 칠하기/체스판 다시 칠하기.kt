fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) { readLine()!!.map { it } }
    var minWrongColor = Int.MAX_VALUE

    for (i in 0..m - 8) {
        for (j in 0..n - 8) {
            val newBoard = board.slice(j until j + 8).map { it.slice(i until i + 8) }
            minWrongColor = minOf(minWrongColor, boardMinWrongCount(newBoard))
        }
    }

    println(minWrongColor)
}

fun boardMinWrongCount(newBoard: List<List<Char>>): Int {
    val boardColor = mutableListOf('B', 'W')
    var correctSum = 0

    for (col in 0 until 8) {
        val colStartChar = boardColor[col % 2]
        correctSum += newBoard[col].filterIndexed { index, c ->
            if (index % 2 == 0) {
                c == colStartChar
            } else {
                c != colStartChar
            }
        }.count()
    }
    return minOf(correctSum, 64 - correctSum)
}