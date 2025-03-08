fun main() {
    val numList = IntArray(5) { readLine()!!.toInt() }.sorted()
    println(numList.average().toInt())
    println(numList[2])
}
