fun main() {
    val xList = mutableListOf<Int>()
    val yList = mutableListOf<Int>()
    repeat(3) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        if (x in xList) xList.remove(x) else xList.add(x)
        if (y in yList) yList.remove(y) else yList.add(y)
    }

    println("${xList.first()} ${yList.first()}")
}