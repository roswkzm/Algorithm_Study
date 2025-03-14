fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!!.split(" ") }.sortedBy { it[0].toInt() }
    array.forEach {
        println(it.joinToString(" "))
    }
}