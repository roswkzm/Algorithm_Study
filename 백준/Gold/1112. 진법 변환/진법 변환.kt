import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val xInput = st.nextToken().toLong()
    val bInput = st.nextToken().toLong()

    println(convertBase(xInput, bInput))
}

private fun convertBase(x: Long, b: Long): String {
    if (x == 0L) return "0"

    return if (b > 0) {
        toPositiveBaseWithSign(x, b)
    } else {
        toNegativeBaseNoSign(x, b)
    }
}

private fun toPositiveBaseWithSign(x: Long, base: Long): String {
    val sign = if (x < 0) "-" else ""
    var n = abs(x)
    val sb = StringBuilder()
    while (n > 0) {
        val r = (n % base).toInt()
        sb.append(digitChar(r))
        n /= base
    }
    return sign + sb.reverse().toString()
}

private fun toNegativeBaseNoSign(x: Long, base: Long): String {
    var n = x
    val absB = abs(base).toInt()
    val sb = StringBuilder()
    while (n != 0L) {
        var r = (n % base).toInt()
        n /= base
        if (r < 0) {
            r += absB
            n += 1
        }
        sb.append(digitChar(r))
    }
    return sb.reverse().toString()
}

private fun digitChar(d: Int): Char {
    return ('0'.code + d).toChar()
}
