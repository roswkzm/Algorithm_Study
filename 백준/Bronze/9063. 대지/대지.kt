fun main() {
    val n = readLine()!!.toInt()
    val xList = mutableListOf<Int>()
    val yList = mutableListOf<Int>()
    repeat(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        xList.add(x)
        yList.add(y)
    }
    println("${(xList.maxOf { it } - xList.minOf { it }) * (yList.maxOf { it } - yList.minOf { it })}")
}