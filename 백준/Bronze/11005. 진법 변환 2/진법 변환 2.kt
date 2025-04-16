fun main() {
    var (n, b) = readLine()!!.split(" ").map { it.toInt() }
    val sb = StringBuilder()

    while (n > 0) {
        val digit = n % b
        sb.append(
            if (digit < 10) digit.toString()
            else ('A' + (digit - 10))
        )
        n /= b
    }

    println(sb.reverse())
}
