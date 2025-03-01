import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var line: String?

    while (br.readLine().also { line = it } != null) {
        val n = line!!.toInt()
        val length = Math.pow(3.0, n.toDouble()).toInt()
        val result = CharArray(length) { '-' }

        fun cantor(start: Int, size: Int) {
            if (size < 3) return
            val segment = size / 3
            for (i in start + segment until start + 2 * segment) {
                result[i] = ' '
            }
            cantor(start, segment)
            cantor(start + 2 * segment, segment)
        }

        cantor(0, length)
        println(result.joinToString(""))
    }
}
