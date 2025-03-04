fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val basket = IntArray(N) { 0 }

    repeat(M) {
        val (i, j, k) = readLine()!!.split(" ").map { it.toInt() }
        for (index in i - 1 until j) {
            basket[index] = k
        }
    }

    println(basket.joinToString(" "))
}