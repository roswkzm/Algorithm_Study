fun main() {
    val n = readLine()!!.toInt()
    var result = 1
    for (i in 2..n) {
        result *= i
    }
    println(result)
}