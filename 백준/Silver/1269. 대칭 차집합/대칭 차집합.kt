fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }.toSet()
    val b = readLine()!!.split(" ").map { it.toInt() }.toSet()
    println("${(a - b).size + (b - a).size}")
}