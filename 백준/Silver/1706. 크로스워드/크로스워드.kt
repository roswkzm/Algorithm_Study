fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val board = Array(r) { readln() }
    val words = mutableListOf<String>()

    for (row in board) {
        words.addAll(row.split('#').filter { it.length >= 2 })
    }

    for (col in 0 until c) {
        var word = ""
        for (row in 0 until r) {
            val ch = board[row][col]
            if (ch != '#') {
                word += ch
            } else {
                if (word.length >= 2) words.add(word)
                word = ""
            }
        }
        if (word.length >= 2) words.add(word)
    }

    println(words.minOrNull())
}
