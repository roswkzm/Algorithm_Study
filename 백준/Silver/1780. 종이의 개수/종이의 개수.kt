import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val paper = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val result = IntArray(3)

    fun checkSame(x: Int, y: Int, size: Int): Boolean {
        val firstNum = paper[x][y]

        for (col in x until x + size) {
            for (row in y until y + size) {
                if (firstNum != paper[col][row]) return false
            }
        }
        return true
    }

    fun divide(x: Int, y: Int, size: Int) {
        if (size == 1 || checkSame(x, y, size)) {
            result[paper[x][y] + 1]++
            return
        }

        val newSize = size / 3

        for (col in 0 until 3) {
            for (row in 0 until 3) {
                divide(x + col * newSize, y + row * newSize, newSize)
            }
        }
    }

    divide(0, 0, n)
    
    result.forEach {
        println(it)
    }
}