fun main() {
    val n = readLine()!!.toInt()
    val files = Array(n) { readLine()!! }
    val length = files[0].length
    val result = CharArray(length)

    for (i in 0 until length) {
        val ch = files[0][i]
        if (files.all { it[i] == ch }) {
            result[i] = ch
        } else {
            result[i] = '?'
        }
    }

    println(result.concatToString())
}
