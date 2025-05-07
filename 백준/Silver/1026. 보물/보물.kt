fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val b = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    var result = 0
    for (i in 0 until n) {
        result += a[i] * b[i]
    }

    println(result)
}