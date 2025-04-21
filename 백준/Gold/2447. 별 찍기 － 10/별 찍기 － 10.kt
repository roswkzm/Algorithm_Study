fun main() {
    val n = readLine()!!.toInt()
    val map = Array(n) { CharArray(n) { ' ' } }

    fun draw(x: Int, y: Int, size: Int) {
        if (size == 1) {
            map[x][y] = '*'
            return
        }

        val newSize = size / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (i == 1 && j == 1) continue
                draw(x + i * newSize, y + j * newSize, newSize)
            }
        }
    }

    draw(0, 0, n)
    println(map.joinToString("\n") { it.joinToString("") })
}
