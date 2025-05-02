fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val indexed = arr.withIndex().sortedBy { it.value }
    val result = IntArray(n)

    for ((newIndex, item) in indexed.withIndex()) {
        result[item.index] = newIndex
    }

    println(result.joinToString(" "))
}