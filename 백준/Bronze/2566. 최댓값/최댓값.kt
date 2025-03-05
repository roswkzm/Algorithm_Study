fun main() {
    val board = Array(9) { IntArray(9) }
    var maxValue = Int.MIN_VALUE
    var maxPosition = 0 to 0
    repeat(9) {
        val result = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        board[it] = result
    }

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (maxValue < board[i][j]) {
                maxValue = board[i][j]
                maxPosition = i + 1 to j + 1
            }
        }
    }

    println(maxValue)
    println("${maxPosition.first} ${maxPosition.second}")
}