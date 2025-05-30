fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(n) { readLine()!!.map { it - '0' }.toIntArray() }
    val b = Array(n) { readLine()!!.map { it - '0' }.toIntArray() }

    fun flip(x: Int, y: Int) {
        for (i in x until x + 3) {
            for (j in y until y + 3) {
                a[i][j] = 1 - a[i][j]
            }
        }
    }

    var count = 0
    for (i in 0 until n - 2) {
        for (j in 0 until m - 2) {
            if (a[i][j] != b[i][j]) {
                flip(i, j)
                count++
            }
        }
    }

    println(if (a.contentDeepEquals(b)) count else -1)
}
