fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }

    var count = 0
    while (Integer.bitCount(n) > k) {
        n++
        count++
    }

    println(count)
}
