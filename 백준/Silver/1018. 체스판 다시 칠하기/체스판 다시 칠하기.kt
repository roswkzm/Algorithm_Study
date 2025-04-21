fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) { readLine()!! }

    var minPaint = Int.MAX_VALUE

    for (i in 0..n - 8) {
        for (j in 0..m - 8) {
            var count1 = 0
            var count2 = 0

            for (x in 0 until 8) {
                for (y in 0 until 8) {
                    val current = board[i + x][j + y]
                    val expected1 = if ((x + y) % 2 == 0) 'W' else 'B'
                    val expected2 = if ((x + y) % 2 == 0) 'B' else 'W'

                    if (current != expected1) count1++
                    if (current != expected2) count2++
                }
            }

            minPaint = minOf(minPaint, count1, count2)
        }
    }

    println(minPaint)
}
