fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!!.split(" ").map { it.toInt() } }.sortedWith(compareBy<List<Int>> { it[1] }.thenBy { it[0] })
    array.forEach {
        println(it.joinToString(" "))
    }
}
