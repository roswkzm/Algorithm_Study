fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!! }.toSet().sortedWith(compareBy<String> { it.length }.thenBy { it })
    array.forEach { 
        println(it)
    }
}