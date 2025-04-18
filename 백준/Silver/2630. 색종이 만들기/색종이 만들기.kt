fun main() {
    val n = readLine()!!.toInt()
    val paper = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    var splitSize = n

    var white = 0
    var blue = 0

    fun countColor(x: Int, y: Int, size: Int) {
        var isSame = true
        val color = paper[x][y]

        for (i in x until x + size) {
            for (j in y until y + size) {
                if (paper[i][j] != color) {
                    isSame = false
                    break
                }
            }
        }

        if (isSame) {
            if (color == 0) white++ else blue++
        } else {
            val half = size / 2
            countColor(x, y, half)
            countColor(x + half, y, half)
            countColor(x, y + half, half)
            countColor(x + half, y + half, half)
        }
    }

    countColor(0, 0, n)
    println(white)
    println(blue)
}