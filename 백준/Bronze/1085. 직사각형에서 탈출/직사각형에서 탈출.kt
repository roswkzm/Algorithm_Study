fun main() {
    val (x, y, w, h) = readLine()!!.split(" ").map { it.toInt() }
    println(minOf(w - x, h - y, x, y))
}