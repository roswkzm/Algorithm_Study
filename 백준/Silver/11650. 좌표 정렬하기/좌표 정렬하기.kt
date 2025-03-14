fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!!.split(" ").map { it.toInt() } }.sortedWith(compareBy<List<Int>> { it[0] }.thenBy { it[1] })
    array.forEach { 
        println(it.joinToString(" "))
    }
}
