fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    var basketList = (1..n).toMutableList()
    repeat(m) {
        val (i, j) = readLine()!!.split(" ").map { it.toInt() }
        basketList.subList(i - 1, j).reverse()
    }
    println(basketList.joinToString(" "))
}