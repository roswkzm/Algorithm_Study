fun main() {
    val s = readLine()!!.trim()
    var zeroCount = 0
    var oneCount = 0
    var prev: Char? = null
    for (c in s) {
        if (c != prev) {
            if (c == '0') zeroCount++ else oneCount++
            prev = c
        }
    }
    println(minOf(zeroCount, oneCount))
}
